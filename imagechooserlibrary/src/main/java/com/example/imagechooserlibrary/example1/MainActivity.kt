package com.example.imagechooserlibrary.example1

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aminography.choosephotohelper.ChoosePhotoHelper
import com.bumptech.glide.Glide
import com.example.imagechooserlibrary.databinding.ActivityMainBinding
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private var selectedImageUri: Uri? = null
    var cameraUri: Uri? = null
    private lateinit var choosePhotoHelper: ChoosePhotoHelper
     private lateinit var viewModel: UploadViewModel




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        viewModel = ViewModelProvider(this)[UploadViewModel::class.java]


        choosePhotoHelper = ChoosePhotoHelper.with(this)
            .asFilePath()
            .withState(savedInstanceState)
            .build {
                Glide.with(this)
                    .load(it)
                    .into(_binding.imageView)
            }
        _binding.tabToSelect.setOnClickListener {

            val values = ContentValues()
            values.put(MediaStore.Images.Media.TITLE, "AppPicture")
            values.put(
                MediaStore.Images.Media.DESCRIPTION,
                "Photo taken on " + System.currentTimeMillis()
            )
            cameraUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            choosePhotoHelper.showChooser()
            uploadImage()
        }

        _binding.buttonUpload.setOnClickListener {
            uploadImage()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        choosePhotoHelper.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            Log.i("“CameraCapture", cameraUri.toString())
            selectedImageUri = cameraUri
            Log.i("ImagePICK", selectedImageUri.toString())
            uploadImage()
            when (requestCode) {
                REQUEST_CODE_PICK_IMAGE -> {
                    selectedImageUri = data?.data
                    _binding.imageView.setImageURI(selectedImageUri)
                    uploadImage()
                }
            }
        }
    }

    private fun uploadImage() {
        val uriPathHelper = URIPathHelper()
        val filePath = uriPathHelper.getPath(this, cameraUri!!)
        Log.i("FilePath", filePath.toString())
        val file = File(filePath)
        val requestFile: RequestBody =
            file.asRequestBody("multipart/form-data".toMediaTypeOrNull())
        val multiPartBody = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val uploadResponse = UploadResponse(multiPartBody.toString())
        viewModel.uploadImage(uploadResponse)



    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        choosePhotoHelper.onRequestPermissionsResult(requestCode, permissions, grantResults)
        uploadImage()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        choosePhotoHelper.onSaveInstanceState(outState)
        uploadImage()
    }

    /* private fun uploadImage() {
         if (selectedImageUri == null) {
             _binding.layoutRoot.snackbar("Select an Image First")
             return
         }

         val parcelFileDescriptor =
             contentResolver.openFileDescriptor(selectedImageUri!!, "r", null) ?: return

         val inputStream = FileInputStream(parcelFileDescriptor.fileDescriptor)
         val file = File(cacheDir, contentResolver.getFileName(selectedImageUri!!))
         val outputStream = FileOutputStream(file)
         inputStream.copyTo(outputStream)

         _binding.progressBar.progress = 0
         val body = UploadCallback?.let { UploadRequestBody(file, "image", it) }
         body?.let {
             MultipartBody.Part.createFormData(
                 "image",
                 file.name,
                 it
             )
         }?.let {
             MyApi().uploadImage(
                 it,
                 "json".toRequestBody("multipart/form-data".toMediaTypeOrNull())
             ).enqueue(object : Callback<UploadResponse> {
                 override fun onFailure(call: Call<UploadResponse>, t: Throwable) {
                     _binding.layoutRoot.snackbar(t.message!!)
                     _binding.progressBar.progress = 0
                 }

                 override fun onResponse(
                     call: Call<UploadResponse>,
                     response: Response<UploadResponse>
                 ) {
                     response.body()?.let {
                         _binding.layoutRoot.snackbar(it.message)
                         _binding.progressBar.progress = 100
                     }
                 }
             })
         }

     }*/


    companion object {
        const val REQUEST_CODE_PICK_IMAGE = 101
        val REQUEST_CODE = 200
        var PERMISSION_ALL = 1
    }


//    https://github.com/Learn2Crack/android-retrofit-image-upload/tree/master/ImageUpload/app/src/main/java/com/learn2crack/imageupload
//    https://www.youtube.com/hashtag/android10fileuploadtutorial
    //https://androidexample365.com/image-picker-library-for-android/

}
package com.example.imageupload

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var pickImage: Button
    private lateinit var upload: Button
     private lateinit var capture: Button

    private val mMediaUri: Uri? = null
    private var fileUri: Uri? = null
    private var mediaPath: String? = null
    private val btnCapturePicture: Button? = null
    private var mImageFileLocation = ""
    private lateinit var pDialog: ProgressDialog
    private var postPath: String? = null

    private val REQUEST_CODE = 200


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById<ImageView>(R.id.imageView)
        pickImage = findViewById<Button>(R.id.btn_select)
        upload = findViewById<Button>(R.id.save)
         capture = findViewById<Button>(R.id.btn_capture)

        pickImage.setOnClickListener {
            openGalleryForImages()
        }

           /*capture.setOnClickListener {
            val takePhotoIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            filePhoto = getPhotoFile(FILE_NAME)

            val providerFile = FileProvider.getUriForFile(
                this,
                "com.example.uploadfile.fileprovider", filePhoto
            )
            takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, providerFile)
            if (takePhotoIntent.resolveActivity(this.packageManager) != null) {
                startActivityForResult(takePhotoIntent, REQUEST_CODE)
            } else {
                Toast.makeText(this, "Camera could not open", Toast.LENGTH_SHORT).show()
            }
        }*/


    }


    private fun openGalleryForImages() {
        if (Build.VERSION.SDK_INT < 24) {
            val intent = Intent()
            intent.type = "image/*"
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(intent, "Choose Pictures"), REQUEST_CODE
            )
        } else { // For latest versions API LEVEL 19+
            val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            intent.type = "image/*"
            startActivityForResult(intent, REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
             // if multiple images are selected
             if (data?.clipData != null) {
                 var count = data.clipData?.itemCount
                 if (count != null) {
                     for (i in 0 until count) {
                         val imageUri: Uri? = data.clipData?.getItemAt(i)?.uri
                             imageView.setImageURI(imageUri) //Here you can assign your Image URI to the ImageViews
                     }
                 }
             } else if (data?.data != null) {
                // if single image is selected
                val imageUri: Uri? = data.data
                imageView.setImageURI(imageUri) //Here you can assign the picked image uri to your imageview
            }
        }
    }
}
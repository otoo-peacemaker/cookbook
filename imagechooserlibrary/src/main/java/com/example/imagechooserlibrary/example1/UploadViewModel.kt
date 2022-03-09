package com.example.imagechooserlibrary.example1

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response

class UploadViewModel : ViewModel() {

    private var selectedImageUri: Uri? = null
    private var userProfileLiveData: MutableLiveData<UploadResponse?> = MutableLiveData()
    fun getUserProfileObserver(): MutableLiveData<UploadResponse?> {
        return userProfileLiveData
    }


    fun uploadImage(multipartBody: UploadResponse) {
        val retIn = ApiClient.getRetrofitInstance().create(ApiInterfaces::class.java)
        val call = retIn.uploadImage("token", multipartBody as MultipartBody.Part)
        call.enqueue(object : retrofit2.Callback<UploadResponse> {
            override fun onResponse(
                call: Call<UploadResponse>,
                response: Response<UploadResponse>
            ) {
                if (response.isSuccessful) {
                    userProfileLiveData.postValue(response.body())
                } else {
                    userProfileLiveData.postValue(null)
                }

            }

            override fun onFailure(call: Call<UploadResponse>, t: Throwable) {
                userProfileLiveData.postValue(null)
            }
        })

    }

    override fun onCleared() {
        super.onCleared()
        userProfileLiveData.value = null
    }

}
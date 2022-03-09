package com.example.imagechooserlibrary.example1

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterfaces {
    @Headers("Accept:application/json")
    @Multipart
    @PUT(Endpoints.profileImg)
    fun uploadImage(
        @Header("Authorization") authorizationHeader: String,
        @Part image: MultipartBody.Part,
    ): Call<UploadResponse>

}
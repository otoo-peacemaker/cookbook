package com.example.uploadfile

import com.google.gson.annotations.SerializedName

data class ImageResponse(
    val id: String,
        // used to map img_src from the JSON to imgSrcUrl in our class
    @SerializedName("img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
)

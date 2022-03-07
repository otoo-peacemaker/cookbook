package com.example.imagechooserlibrary.example1

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {

    object ClientIDs {
        const val CLIENT_ID = "MY_CLIENT_ID"
        const val REDIRECT_URI = "MY_REDIRECT_URI"
        const val SCOPE = "name%20email"

        const val AUTHURL = "https://appleid.apple.com/auth/authorize"
        const val TOKENURL = "https://appleid.apple.com/auth/token"


    }


    companion object {
        //interceptor
        private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        //okClient
        private val client: OkHttpClient = OkHttpClient.Builder().apply {
//            this.addInterceptor(TokenInterceptor())
//           this.addInterceptor(NetworkManager())
            this.addInterceptor(interceptor)
            this.connectTimeout(1, TimeUnit.MINUTES)
            this.writeTimeout(1, TimeUnit.MINUTES)
            this.readTimeout(1, TimeUnit.MINUTES)
        }.build()

        //retrofit
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(Endpoints.devBaseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
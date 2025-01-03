package com.example.kuit_4th_hackathon_team2_android.retrofit

import android.util.Log
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    //val BASE_URL = "https://673d9ac20118dbfe8607ee6a.mockapi.io/kuit/" //민지
//    val BASE_URL = "https://673ce2bd4db5a341d8334b69.mockapi.io/kuit/" //수민
    var cookies = ""
    val BASE_URL = "http://3.36.74.146:8080/"


    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun setCookie(cookie: String) {
        if (cookies.isEmpty()) {
            cookies = cookie
            Log.e("쿠키", cookies)
        } else {
            Log.d("cookie" , "none")
        }

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClient(cookie)) // OkHttpClient 추가
            .build()

    }

    private fun createOkHttpClient(cookies: String): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(LoginInterceptor(cookies)) // 쿠키 인터셉터 추가
            .build()
    }


}
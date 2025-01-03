package com.example.kuit_4th_hackathon_team2_android.Retrofit

import com.example.kuit_4th_hackathon_team2_android.BuildConfig.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    //val BASE_URL = "https://673d9ac20118dbfe8607ee6a.mockapi.io/kuit/" //민지
    val BASE_URL = "https://673ce2bd4db5a341d8334b69.mockapi.io/kuit/" //수민

    //val BASE_URL = "http://3.36.74.146:8080/"
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
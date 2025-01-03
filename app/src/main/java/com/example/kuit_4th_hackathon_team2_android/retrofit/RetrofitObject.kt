package com.example.kuit_4th_hackathon_team2_android.Retrofit

import com.example.kuit_4th_hackathon_team2_android.BuildConfig.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    val BASE_URL = "http://3.36.74.146:8080/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
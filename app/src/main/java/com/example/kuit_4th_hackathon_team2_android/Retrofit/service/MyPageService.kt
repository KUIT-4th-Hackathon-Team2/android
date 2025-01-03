package com.example.kuit_4th_hackathon_team2_android.Retrofit.service

import com.example.kuit_4th_hackathon_team2_android.admin.model.LentalData
import com.example.kuit_4th_hackathon_team2_android.mypage.model.MyPageData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyPageService {
    @GET("rentals/user/{userId}")
    fun getRentalItem(@Path("userId") userid : Int): Call<List<MyPageData>>
}
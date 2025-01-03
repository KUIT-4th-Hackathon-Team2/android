package com.example.kuit_4th_hackathon_team2_android.Retrofit.service

import com.example.kuit_4th_hackathon_team2_android.admin.model.LentalData
import retrofit2.Call
import retrofit2.http.GET

interface AdminRentalService {
    @GET("reservations")
    fun getRentalItem(): Call<List<LentalData>>

}
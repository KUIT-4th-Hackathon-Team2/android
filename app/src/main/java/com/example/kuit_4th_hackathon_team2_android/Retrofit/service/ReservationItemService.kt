package com.example.kuit_4th_hackathon_team2_android.Retrofit.service

import com.example.kuit_4th_hackathon_team2_android.reservation.reservation.ReservationData
import retrofit2.Call
import retrofit2.http.GET

interface ReservationItemService {
    @GET("products")
    fun getReservationItems(): Call<List<ReservationData>>
}
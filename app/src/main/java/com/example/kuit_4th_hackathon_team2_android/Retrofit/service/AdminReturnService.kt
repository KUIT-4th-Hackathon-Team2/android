package com.example.kuit_4th_hackathon_team2_android.Retrofit.service

import com.example.kuit_4th_hackathon_team2_android.admin.model.LentalData
import com.example.kuit_4th_hackathon_team2_android.admin.model.ReservationData
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AdminReturnService {
    @GET("rentals")
    fun getReturnItem(): Call<List<ReservationData>>

    @DELETE("rentals/{rentalId}")
    fun removeItem(@Path("rentalId") rentalId:Int) : Call<List<ReservationData>>
}
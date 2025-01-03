package com.example.kuit_4th_hackathon_team2_android.Retrofit.service

import com.example.kuit_4th_hackathon_team2_android.reservation.ReservationData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ReservationItemService {
    @GET("reservation")
    fun getReservationItems(): Call<List<ReservationData>>


//    @POST("reservation")
//    fun postReservationItem(
//        @Body reservationData: ReservationData
//    ): Call<ReservationData>
//
//
//    @DELETE("reservation/{id}")
//    fun deleteReservationItem(
//        @Path("id") id: String,
//    ): Call<Void>
}
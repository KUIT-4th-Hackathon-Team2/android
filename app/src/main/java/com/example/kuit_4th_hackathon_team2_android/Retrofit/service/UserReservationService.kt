package com.example.kuit_4th_hackathon_team2_android.retrofit.service

import com.example.kuit_4th_hackathon_team2_android.reservation.reservation.ReservationData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface UserReservationService {
    @GET("reservations/user/{userId}")
    fun getUserReservationItems() : Call<List<ReservationData>>

    @POST("reservations")
    fun postReservationItem(
        @Body reservationData: ReservationData
    ): Call<ReservationData>

    @DELETE("reservations/{reservationId}")
    fun deleteReservationItem(
        @Body reservationData: ReservationData
    ): Call<Void>


}
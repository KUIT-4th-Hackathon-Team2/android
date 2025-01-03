package com.example.kuit_4th_hackathon_team2_android.Retrofit.service

import com.example.kuit_4th_hackathon_team2_android.reservation.BorrowData
import retrofit2.Call
import retrofit2.http.GET

interface UserBorrowItemService {
    @GET("borrow")
    fun getUserBorrowItems() : Call<List<BorrowData>>
}
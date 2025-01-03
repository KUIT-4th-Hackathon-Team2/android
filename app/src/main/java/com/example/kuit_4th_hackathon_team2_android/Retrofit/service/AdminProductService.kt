package com.example.kuit_4th_hackathon_team2_android.Retrofit.service

import com.example.kuit_4th_hackathon_team2_android.admin.model.LentalData
import com.example.kuit_4th_hackathon_team2_android.admin.model.ProductData
import com.example.kuit_4th_hackathon_team2_android.admin.model.ReservationData
import retrofit2.Call
import retrofit2.http.GET

interface AdminProductService {
    @GET("products")
    fun getProductItem(): Call<List<ProductData>>

}
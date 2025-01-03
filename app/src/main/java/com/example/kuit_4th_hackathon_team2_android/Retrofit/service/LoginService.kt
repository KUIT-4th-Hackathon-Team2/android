package com.example.kuit_4th_hackathon_team2_android.Retrofit.service

import com.example.kuit_4th_hackathon_team2_android.login.model.LoginData
import com.example.kuit_4th_hackathon_team2_android.login.model.ResponseData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("users/login")
    fun postLoginData(
        @Body reservationData: LoginData
    ): Call<ResponseData>
}
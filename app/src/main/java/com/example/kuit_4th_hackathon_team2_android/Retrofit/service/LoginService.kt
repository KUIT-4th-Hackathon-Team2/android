package com.example.kuit_4th_hackathon_team2_android.retrofit.service


import com.example.kuit_4th_hackathon_team2_android.login.model.LoginData
import com.example.kuit_4th_hackathon_team2_android.login.model.ResponseData
import com.example.kuit_4th_hackathon_team2_android.login.model.UserData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("users/login")
    fun postLoginData(
        @Body reservationData: LoginData
    ): Call<ResponseData>

    @POST("users/signup")
    fun postUser(
        @Body userData: UserData
    ): Call<ResponseData>
}
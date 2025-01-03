package com.example.kuit_4th_hackathon_team2_android.retrofit.Service

import com.example.kuit_4th_hackathon_team2_android.retrofit.LoginResponseData
import com.example.kuit_4th_hackathon_team2_android.retrofit.UserData
import com.example.kuit_4th_hackathon_team2_android.retrofit.LoginRequestData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST



interface LoginService {
    @POST("user")
    fun postUser(
        @Body request: LoginResponseData
    ): Call<LoginResponseData>

    @POST("login")
    fun login(
        @Body loginRequest: LoginRequestData
    ): Call<LoginResponseData>

    @GET("user")
    fun getUser(): Call<LoginResponseData>
}

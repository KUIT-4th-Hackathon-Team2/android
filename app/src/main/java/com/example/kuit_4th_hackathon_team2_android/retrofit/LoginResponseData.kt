package com.example.kuit_4th_hackathon_team2_android.retrofit

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseData(
    val userId : String,
    val userName: Int,
    val studentNum: String,
    val role : String
)

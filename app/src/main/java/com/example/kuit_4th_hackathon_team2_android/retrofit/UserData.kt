package com.example.kuit_4th_hackathon_team2_android.retrofit

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val userName: String,
    val studentNum: String,
    val password: String,
    val role: String
)

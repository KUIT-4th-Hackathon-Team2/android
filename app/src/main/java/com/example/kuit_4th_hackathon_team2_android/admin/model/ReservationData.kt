package com.example.kuit_4th_hackathon_team2_android.admin.model

data class ReservationData (
    val rentalId: Int,
    val productId: Int,
    val productName: String,
    val userId: Int,
    val userName: String,
    val studentNum: Long,
    val rentalTime: String,
    val expirationTime: String
)
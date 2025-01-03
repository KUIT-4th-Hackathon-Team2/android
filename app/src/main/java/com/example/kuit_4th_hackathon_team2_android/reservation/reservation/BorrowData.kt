package com.example.kuit_4th_hackathon_team2_android.reservation.reservation

data class BorrowData(
    val rentalId : Int,
    val productId : Int,
    val productName : String,
    val rentalTime : String,
    val expirationDate: String
)

package com.example.kuit_4th_hackathon_team2_android.reservation.reservation

data class ReservationUserData (
    val rentalId : Int,
    val productId : Int,
    val productName : String,
    val rentalTime : String,
    val expirationDate: String
    )
package com.example.goldapp.remote.detaModel.goldModel

data class Gold(
    val `data`: Data,
    val last_update: String,
    val message: String,
    val source: String,
    val success: Int
)
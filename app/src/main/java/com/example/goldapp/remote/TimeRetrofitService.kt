package com.example.goldapp.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TimeRetrofitService {

    private const val URL ="https://tools.daneshjooyar.com/api/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService:TimeApiService = retrofit.create(TimeApiService::class.java)

}
package com.example.goldapp.remote

import com.example.goldapp.remote.time.TimeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MainRetrofitService {

    private const val URL ="https://tools.daneshjooyar.com/api/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: TimeApiService = retrofit.create(TimeApiService::class.java)

}
package com.example.goldapp.remote

import retrofit2.Retrofit

object TimeRetrofitService {

    private const val URL ="https://tools.daneshjooyar.com/api/v1/date/now"

    private val retrofit = Retrofit.Builder()
        .baseUrl(URL)
}
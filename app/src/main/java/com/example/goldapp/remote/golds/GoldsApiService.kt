package com.example.goldapp.remote.golds

import com.example.goldapp.remote.detaModel.timeModel.DateModel
import retrofit2.Call
import retrofit2.http.GET

interface GoldsApiService {
    @GET("currencies")
    fun  getGolds():Call<DateModel>
}
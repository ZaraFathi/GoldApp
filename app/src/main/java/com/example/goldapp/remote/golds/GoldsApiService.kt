package com.example.goldapp.remote.golds


import com.example.goldapp.remote.detaModel.GoldModel
import retrofit2.Call
import retrofit2.http.GET

interface GoldsApiService {
    @GET("currencies")
    fun  getGolds():Call<GoldModel>
}
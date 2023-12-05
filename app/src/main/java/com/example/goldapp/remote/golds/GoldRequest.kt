package com.example.goldapp.remote.golds

import com.example.goldapp.remote.detaModel.GoldModel

interface GoldRequest {
    fun onSuccess(data:GoldModel)
    fun onNotSuccess(message:String)
    fun onError(error:String)
}
package com.example.goldapp.remote.time

import com.example.goldapp.remote.detaModel.timeModel.DateModel

interface TimeRequest {

    fun onSuccess(data: DateModel)

    fun onNotSuccess(message:String)

    fun onError(error:String)





}
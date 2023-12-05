package com.example.goldapp.remote.detaModel


data class GoldModel(
    val message:String,
    val data: AllData
)
data class AllData(
    val golds :List<ContentModel>,
    val currencies:List<ContentModel>
)
data class ContentModel(
    val label:String,
    val price:Int
)

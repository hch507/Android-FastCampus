package com.example.finedust_app.data.models.monitoringstation

import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("totalCount")
    val totalCount:Int?,
    @SerializedName("items")
    val items : List<MornitoringItems>?,
    @SerializedName("numOfRows")
    val NumOfRows : Int?,
    @SerializedName("pageNo")
    val pageNo : Int,

    )

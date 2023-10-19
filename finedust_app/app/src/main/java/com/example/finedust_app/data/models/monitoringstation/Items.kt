package com.example.finedust_app.data.models.monitoringstation

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("tm")
    val tm :Double?,
    @SerializedName("add")
    val add : String?,
    @SerializedName("stationName")
    val stationName : String?,
)

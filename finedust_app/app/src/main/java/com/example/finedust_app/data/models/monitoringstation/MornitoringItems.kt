package com.example.finedust_app.data.models.monitoringstation

import com.google.gson.annotations.SerializedName

data class MornitoringItems(
    @SerializedName("tm")
    val tm :Double?,
    @SerializedName("addr")
    val addr : String?,
    @SerializedName("stationName")
    val stationName : String?,
)

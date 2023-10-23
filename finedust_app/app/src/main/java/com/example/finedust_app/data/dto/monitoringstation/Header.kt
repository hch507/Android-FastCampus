package com.example.finedust_app.data.dto.monitoringstation

import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("resultMsg")
    val resultMsg : String?,
    @SerializedName("resultCode")
    val resultCode : String?
)

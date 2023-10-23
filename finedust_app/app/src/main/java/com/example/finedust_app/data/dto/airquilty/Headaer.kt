package com.example.finedust_app.data.dto.airquilty

import com.google.gson.annotations.SerializedName

data class Headaer(
    @SerializedName("resultCode")
    val resultCode :Int?,
    @SerializedName("resultMsg")
    val resultMsg : String?
)

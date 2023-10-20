package com.example.finedust_app.data.models.airquilty

import com.google.gson.annotations.SerializedName

data class Body (
    @SerializedName("items")
    val items : List<AirQualityItems>?,

    @SerializedName("numOfRows")
    val numOfRows : Int?,

    @SerializedName("pageNo")
    val pageNo : Int?,

    @SerializedName("totalCount")
    val totalCount : Int?
)
package com.example.finedust_app.data.dto.tmcoordinates

import com.google.gson.annotations.SerializedName

data class TmcoordinatesResponse(
    @SerializedName("documents")
    val documents: List<Documents>,
    @SerializedName("meta")
    val meta:Meta
)

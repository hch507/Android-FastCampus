package com.example.finedust_app.data.models.airquilty

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("header")
    var header : Headaer,
    @SerializedName("body")
    var body: Body
)

package com.example.finedust_app.data.dto.airquilty

import com.google.gson.annotations.SerializedName

enum class Grade(
    val label: String,
    val emoji: String
) {
    @SerializedName("1")
    GOOD("좋음","😍"),

    @SerializedName("2")
    NORMAL("보통","😊"),
    @SerializedName("3")
    BAD("나쁨","😢"),
    @SerializedName("4")
    AWFUL("메우 나쁨","😂"),

    UNKNOWN("정보없음","😁");


    override fun toString(): String {
        return "${label}${emoji}"
    }

}

package com.example.finedust_app.data.dto.airquilty

import com.google.gson.annotations.SerializedName


//so-아황산가스 co-이산화탄소 o-오존 no-이산화질소 pm-미세먼지 pm25-초미세먼지
data class AirQualityItems(

    @SerializedName("pm25Grade1h")
    val pm25Grade1h : Grade?,

    @SerializedName("pm10Value24")
    val pm10Value24 : String?,

    @SerializedName("so2Value")
    val so2Value : String?,

    @SerializedName("pm10Grade1h")
    val pm10Grade1h : Grade?,

    @SerializedName("o3Grade")
    val o3Grade : Grade?,

    @SerializedName("pm10Value")
    val pm10Value : String?,

    @SerializedName("pm25Flag")
    val pm25Flag : Any?,

    @SerializedName("khaiGrade")
    val khaiGrade : Grade?,

    @SerializedName("pm25Value")
    val pm25Value : String?,

    @SerializedName("no2Flag")
    val no2Flag : Any?,

    @SerializedName("mangName")
    val mangName : String?,

    @SerializedName("no2Value")
    val no2Value : String?,

    @SerializedName("so2Grade")
    val so2Grade : Grade?,

    @SerializedName("coFlag")
    val coFlag : Any?,

    @SerializedName("khaiValue")
    val khaiValue : String?,

    @SerializedName("coValue")
    val coValue : String?,

    @SerializedName("pm10Flag")
    val pm10Flag : Any?,

    @SerializedName("no2Grade")
    val no2Grade : Grade?,

    @SerializedName("pm25Value24")
    val pm25Value24 : String?,

    @SerializedName("o3Flag")
    val o3Flag : Any?,

    @SerializedName("pm25Grade")
    val pm25Grade : Grade?,

    @SerializedName("so2Flag")
    val so2Flag : Any?,

    @SerializedName("coGrade")
    val coGrade : Grade?,

    @SerializedName("dataTime")
    val dataTime : String?,

    @SerializedName("pm10Grade")
    val pm10Grade : Grade?,

    @SerializedName("o3Value")
    val o3Value : String?
)

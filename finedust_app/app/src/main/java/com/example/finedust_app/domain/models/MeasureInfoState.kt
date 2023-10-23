package com.example.finedust_app.domain.models

import com.example.finedust_app.data.dto.airquilty.Grade

data class MeasureInfoState(
    val measureStationName : String?,
    val measureStationAddress : String?,
    val totalGradeLabel : String?,
    val totalGradeEmoji : String?,
    val fineDustInfomation : String?,
    val ultrafineDustInfomation : String?,
    val so2Grade : Grade?,
    val so2Value : String?,
    val coGrade : Grade?,
    val coValue : String?,
    val o3Grade : Grade?,
    val o3Value: String?,
    val no2Grade: Grade?,
    val no2Value : String?
)

package com.example.finedust_app.data

import com.example.finedust_app.data.services.KakaoLocalApiService
import com.example.finedust_app.utils.Url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Inject

data class coordinate(
    val tmX : Double,
    val tmY : Double
)
class CoordinateRepository @Inject constructor(
    private val kakaoLocalApiService: KakaoLocalApiService
) {
    suspend fun getCoodidate(latitude: Double, longitude: Double): coordinate {
        val tmCoordinates = kakaoLocalApiService
            .getTmCoordinate(longitude, latitude)
            .body()
            ?.documents
            ?.firstOrNull()
        val tmX = tmCoordinates?.x
        val tmY = tmCoordinates?.y
        val coordinateData = coordinate(tmX!!, tmY!!)
        return coordinateData
    }
}

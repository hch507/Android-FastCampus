package com.example.finedust_app.data

import com.example.finedust_app.data.services.KakaoLocalApiService
import com.example.finedust_app.utils.Url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

data class coordinate(
    val tmX : Double,
    val tmY : Double
)
object CoordinateRepository {



    suspend fun getCoodidate(latitude: Double, longitude: Double): coordinate {
        val tmCoordinates = CoordinateRepository.kakaoLocalApiService
            .getTmCoordinate(longitude, latitude)
            .body()
            ?.documents
            ?.firstOrNull()
        val tmX = tmCoordinates?.x
        val tmY = tmCoordinates?.y
        val coordinateData = coordinate(tmX!!, tmY!!)
        return coordinateData
    }

    private val kakaoLocalApiService : KakaoLocalApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Url.KAKAO_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}

package com.example.finedust_app.data

import android.util.Log
import com.example.finedust_app.data.models.monitoringstation.Items
import com.example.finedust_app.data.services.AirKoreaApiService
import com.example.finedust_app.data.services.KakaoLocalApiService
import com.example.finedust_app.utils.Url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Repository {

    suspend fun getNearbyMonitoringStation(latitude:Double,longitude:Double): Items? {
        val  tmCoordinates = kakaoLocalApiService
            .getTmCoordinate(longitude , latitude)
            .body()
            ?.documents
            ?.firstOrNull()
        Log.d("hch", "getNearbyMonitoringStation: ${kakaoLocalApiService.getTmCoordinate(longitude , latitude).body()}")
        val tmX = tmCoordinates?.x
        val tmY = tmCoordinates?.y
        Log.d("hch", "getNearbyMonitoringStation: ${tmX},${tmY}")

        return airKoreaApiService
            .getNearbyMonitoringStation(tmX!!,tmY!!)
            .body()
            ?.response
            ?.body
            ?.items
            ?.minByOrNull { it.tm ?: Double.MAX_VALUE }

    }

    private val kakaoLocalApiService : KakaoLocalApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Url.KAKAO_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
    private val airKoreaApiService : AirKoreaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Url.AIRKOREA_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}
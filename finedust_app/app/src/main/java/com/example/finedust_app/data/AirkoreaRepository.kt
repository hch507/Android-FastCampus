package com.example.finedust_app.data

import android.util.Log
import com.example.finedust_app.data.dto.airquilty.AirQualityItems
import com.example.finedust_app.data.dto.monitoringstation.MornitoringItems
import com.example.finedust_app.data.services.AirKoreaApiService
import com.example.finedust_app.utils.Url
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object AirkoreaRepository {

    suspend fun getNearbyMonitoringStation(tmX:Double,tmY:Double): MornitoringItems? {

        val nearbyStation =airKoreaApiService
            .getNearbyMonitoringStation(tmX!!,tmY!!)
            .body()
            ?.response
            ?.body
            ?.items
            ?.minByOrNull { it.tm ?: Double.MAX_VALUE }
        Log.d("hch", "getNearbyMonitoringStation: ${nearbyStation}")
        return nearbyStation

    }
    suspend fun getLatestAirQualityData(stationName :String):AirQualityItems? {
        Log.d("hch", "getLatestAirQualityData: ")
        val value =airKoreaApiService
            .getRealtimeAirQualties(stationName)
            .body()
            ?.respponse
            ?.body
            ?.items
            ?.firstOrNull()

        return value
    }


    private val airKoreaApiService : AirKoreaApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Url.AIRKOREA_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }
}
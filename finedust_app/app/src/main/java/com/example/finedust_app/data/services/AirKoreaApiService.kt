package com.example.finedust_app.data.services

import com.example.finedust_app.data.dto.airquilty.AirQualityResponse
import com.example.finedust_app.data.dto.monitoringstation.MonitoringStaitionResponse
import com.example.finedust_app.utils.ApiKey
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AirKoreaApiService {

    @GET("B552584/MsrstnInfoInqireSvc/getNearbyMsrstnList" +
        "?serviceKey=${ApiKey.AIRKOREA_SERVICE_KEY}" +
        "&returnType=json")
    suspend fun getNearbyMonitoringStation(
        @Query("tmX") tmX : Double,
        @Query("tmY") tmY : Double
    ):Response<MonitoringStaitionResponse>

    @GET("B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty"+
            "?serviceKEY=${ApiKey.AIRKOREA_SERVICE_KEY}" +
            "&returnType=json"+
            "&dataTerm=DAILY"+
            "&ver=1.3")
    suspend fun getRealtimeAirQualties(
        @Query("stationName") stationName : String
    ):Response<AirQualityResponse>
}
package com.example.finedust_app.domain

import android.util.Log
import com.example.finedust_app.data.CoordinateRepository
import com.example.finedust_app.data.AirkoreaRepository
import com.example.finedust_app.domain.models.MeasureInfoState
import javax.inject.Inject

class GetMeasureInfoUseCase @Inject constructor(
    private val coordinateRepository: CoordinateRepository,
    private val airKoreaRepository: AirkoreaRepository
)  {
     operator suspend fun invoke(latitude: Double, longitude: Double):MeasureInfoState {
         val coodinate = coordinateRepository.getCoodidate(latitude, longitude)
         Log.d("hch", "invoke: coordinate: ${coodinate} ")
         val monitoringInfo = airKoreaRepository.getNearbyMonitoringStation(coodinate.tmX,coodinate.tmY )
         Log.d("hch", "invoke: monitoring ${monitoringInfo}")
         val airQualityInfo = airKoreaRepository.getLatestAirQualityData(monitoringInfo?.stationName!!)
         Log.d("hch", "invoke: monitoring ${airQualityInfo}")
         return MeasureInfoState(
             measureStationName = monitoringInfo.stationName,
             measureStationAddress = monitoringInfo.addr,
             totalGradeLabel = airQualityInfo?.khaiGrade?.label,
             totalGradeEmoji = airQualityInfo?.khaiGrade?.emoji,
             fineDustInfomation = airQualityInfo?.pm10Grade?.emoji,
             ultrafineDustInfomation = airQualityInfo?.pm25Grade?.emoji ,
             so2Grade = airQualityInfo?.so2Grade,
             so2Value = airQualityInfo?.so2Value,
             coGrade = airQualityInfo?.coGrade,
             coValue = airQualityInfo?.coValue,
             o3Grade = airQualityInfo?.o3Grade,
             o3Value = airQualityInfo?.o3Value,
             no2Grade = airQualityInfo?.no2Grade,
             no2Value = airQualityInfo?.no2Value
         )
    }
}

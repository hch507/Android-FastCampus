package com.example.finedust_app.data.services

import com.example.finedust_app.data.dto.tmcoordinates.TmcoordinatesResponse
import com.example.finedust_app.di.NetworkModules
import com.example.finedust_app.utils.ApiKey
import retrofit2.Response
import retrofit2.http.GET

import retrofit2.http.Headers
import retrofit2.http.Query

@NetworkModules.KakaoRrtrofit
interface KakaoLocalApiService {
    @Headers("Authorization: KakaoAK ${ApiKey.KAKAO_API_KEY}")
    @GET("v2/local/geo/transcoord.JSON?output_coord=TM")
    suspend fun getTmCoordinate(
        @Query("x") longitude: Double,
        @Query("y") latitude : Double
    ) : Response<TmcoordinatesResponse>
}
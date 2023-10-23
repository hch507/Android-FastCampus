package com.example.finedust_app.di

import com.example.finedust_app.data.services.AirKoreaApiService
import com.example.finedust_app.data.services.KakaoLocalApiService
import com.example.finedust_app.utils.Url
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModules{

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class KakaoRrtrofit

    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class AirKoreaRetrofit

    @Provides
    @Singleton
    @KakaoRrtrofit
    fun provideKakaoRerofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Url.KAKAO_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    @AirKoreaRetrofit
    fun provideAirKoreaRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(Url.AIRKOREA_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideAirKoreaApiService(@AirKoreaRetrofit retrofit: Retrofit):AirKoreaApiService =retrofit.create(AirKoreaApiService::class.java)

    @Provides
    @Singleton
    fun provideKakaoApiService(@KakaoRrtrofit retrofit: Retrofit):KakaoLocalApiService= retrofit.create(KakaoLocalApiService::class.java)
}
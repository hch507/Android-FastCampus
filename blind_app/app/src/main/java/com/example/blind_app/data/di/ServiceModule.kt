package com.example.blind_app.data.di

import com.example.blind_app.data.source.remote.api.ContentService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Singleton
    @Provides
    fun providesContentService(retrofit: Retrofit): ContentService = retrofit.create(ContentService::class.java)
}
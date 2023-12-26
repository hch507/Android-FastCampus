package com.example.blind_app.data.di

import com.example.blind_app.data.source.local.AppDatabasee
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Singleton
    @Provides
    fun provideContentDao(appDatabasee: AppDatabasee)= appDatabasee.contentDao()
}
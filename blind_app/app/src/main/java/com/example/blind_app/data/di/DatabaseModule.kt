package com.example.blind_app.data.di

import android.content.Context
import androidx.room.Room
import com.example.blind_app.data.source.local.AppDatabasee
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context : Context): AppDatabasee{
        return Room.databaseBuilder(context, AppDatabasee::class.java, "chapter8.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
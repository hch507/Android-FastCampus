package com.example.blind_app.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.blind_app.data.model.entity.ContentEntity
import com.example.blind_app.data.source.local.dao.ContentDao

@Database(entities = [ContentEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabasee: RoomDatabase() {
    abstract fun contentDao():ContentDao
}
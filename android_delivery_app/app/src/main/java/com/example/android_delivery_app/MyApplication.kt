package com.example.android_delivery_app

import android.app.Application
import android.content.Context

/**
 * appContext는 NULL로 바꿔줘야함
 *
 * */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    override fun onTerminate() {
        super.onTerminate()
        appContext = null
    }

    companion object{
        var appContext : Context? = null
            private set
    }
}
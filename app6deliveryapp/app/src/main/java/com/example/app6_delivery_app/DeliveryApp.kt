package com.example.app6_delivery_app

import android.app.Application
import android.content.Context

class DeliveryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this
    }

    override fun onTerminate() {
        super.onTerminate()
        appContext = null
    }
    companion object{
        var appContext: Context? =null
        private set
    }
}
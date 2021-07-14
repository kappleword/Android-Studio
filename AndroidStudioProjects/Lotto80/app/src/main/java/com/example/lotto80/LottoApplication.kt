package com.example.lotto80

import android.app.Application
import android.content.Context

class LottoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appContext = this;
    }

    override fun onTerminate() {//앱이 종료될때
        super.onTerminate()
        appContext = null
    }
    companion object{
        var appContext: Context? = null
        private set
    }
}
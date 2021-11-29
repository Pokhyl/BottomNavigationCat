package com.example.bottomnavigationcat

import android.app.Application
import com.example.bottomnavigationcat.di.DaggerMainComponent
import com.example.bottomnavigationcat.di.MainComponent

class MainApp: Application() {
    lateinit var mainCompjnent:MainComponent
    override fun onCreate() {
        super.onCreate()
        mainCompjnent = DaggerMainComponent
            .builder()
            .build()
    }
}
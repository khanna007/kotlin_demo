package com.example.kotlin_demo.presentation

import android.app.Application
import com.example.kotlin_demo.di.compunent.AppComponent
 import com.example.kotlin_demo.di.core.module.AppModule
import com.example.kotlin_demo.di.network.NetworkModule

class CountryApplication : Application() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .networkModule(NetworkModule())
            .build()
        appComponent.inject(this)
    }

}
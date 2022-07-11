package com.example.kotlin_demo.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class CountryApplication : Application() {

    override fun onCreate() {

        super.onCreate()
        println("Hello")
    }
}
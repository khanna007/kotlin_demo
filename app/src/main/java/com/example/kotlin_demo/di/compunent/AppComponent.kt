package com.example.kotlin_demo.di.compunent

import com.example.kotlin_demo.di.core.module.AppModule
import com.example.kotlin_demo.di.network.NetworkModule
import com.example.kotlin_demo.presentation.CountryApplication
import dagger.Component
import javax.inject.Singleton
import com.example.kotlin_demo.presentation.MainActivity
import com.example.kotlin_demo.presentation.fragment.FirstFragment


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])

interface AppComponent {
    fun inject(application : CountryApplication)
    fun inject(activity: MainActivity?)
    fun inject(fragment : FirstFragment?)
}
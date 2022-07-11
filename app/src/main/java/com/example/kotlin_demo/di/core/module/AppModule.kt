//package com.example.kotlin_demo.di.core.module
//
//import android.content.Context
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//class AppModule constructor(context: Context) {
//    private val appContext = context.applicationContext
//
//    @Singleton
//    @Provides
//    fun provideAppContext(): Context {
//        return appContext
//    }
//}
package com.example.kotlin_demo.di.core.module

import com.example.kotlin_demo.data.api.CountryInterface
import com.example.kotlin_demo.data.remote.CountryImplementaiton
import com.example.kotlin_demo.domain.repository.CountryRepository
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

class DataModule {

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): CountryInterface {
        return retrofit.create(CountryInterface::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(api:CountryInterface): CountryRepository {
        return CountryImplementaiton(api)

    }
}
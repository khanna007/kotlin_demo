package com.example.kotlin_demo.di.core.module

import com.example.kotlin_demo.data.api.CountryInterface
import com.example.kotlin_demo.data.remote.CountryImplementation
import com.example.kotlin_demo.domain.repository.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Singleton
    @Provides
    fun provideRepository(api:CountryInterface): CountryRepository {
        return CountryImplementation(api)

    }
}
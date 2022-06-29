package com.example.kotlin_demo.domain

import com.example.kotlin_demo.data.CountryModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("/users")
    fun listCountries(): Call<List<CountryModel>>


}
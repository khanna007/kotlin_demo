package com.example.kotlin_demo.data.api

import com.example.kotlin_demo.data.model.CountryModel
import io.reactivex.Single
import retrofit2.http.GET

interface CountryInterface {
    @GET("breweries")
    fun getCountries(): Single<List<CountryModel>>
}
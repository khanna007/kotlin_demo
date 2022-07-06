package com.example.kotlin_demo.data.remote

import com.example.kotlin_demo.data.CountryModel
import io.reactivex.Single
import retrofit2.http.GET

interface CountryInterface {
    @GET("breweries")
    fun getCountries(): Single<List<CountryModel>>
}
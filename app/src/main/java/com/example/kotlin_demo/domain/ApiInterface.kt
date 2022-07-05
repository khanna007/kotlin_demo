package com.example.kotlin_demo.domain

import com.example.kotlin_demo.data.CountryModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries(): Single<List<CountryModel>>
}
package com.example.kotlin_demo.domain.repository

 import com.example.kotlin_demo.domain.model.Country
 import io.reactivex.Single

interface CountryRepository {

      fun getCountries(): Single<List<Country>>
}
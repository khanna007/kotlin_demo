package com.example.kotlin_demo.domain.repository

import com.example.kotlin_demo.data.CountryModel
import io.reactivex.Single

interface CountryRepository {

      fun getCountries(): Single<List<CountryModel>>
}
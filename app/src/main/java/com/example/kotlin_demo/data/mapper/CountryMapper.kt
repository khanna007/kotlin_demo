package com.example.kotlin_demo.data.mapper

import com.example.kotlin_demo.data.model.CountryModel
import com.example.kotlin_demo.domain.model.Country
import io.reactivex.Single

class CountryMapper {


    fun countryModelMapper(response: Single<List<CountryModel>>): Single<List<Country>> {
      return  response.map { it1 ->
            {
                it1.map {
                    Country(countryName = it.countryName, countryCapital = it.capital)
                }

            }
        }as Single<List<Country>>
    }
}
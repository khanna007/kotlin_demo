package com.example.kotlin_demo.util

import com.example.kotlin_demo.data.CountryModel
import com.example.kotlin_demo.data.local.CountryLocal

class CountryMapper  {

    fun transferDomailModelToLocalModel(countryModel: CountryModel):CountryLocal{
        return CountryLocal(1,countryModel?.countryName,countryModel.capital,countryModel.flag)

    }
}
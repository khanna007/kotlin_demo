package com.example.kotlin_demo.data.model

import com.google.gson.annotations.SerializedName

data class CountryModel(
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("brewery_type")
    val capital: String?,
)

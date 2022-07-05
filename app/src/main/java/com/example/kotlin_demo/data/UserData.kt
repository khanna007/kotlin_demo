package com.example.kotlin_demo.data

import com.google.gson.annotations.SerializedName

data class CountryModel(
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("capital")
    val capital: String?,
    @SerializedName("flagPNG")
    val flag: String?
)


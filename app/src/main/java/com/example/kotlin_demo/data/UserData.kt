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

//data class CountryModel(
//    @SerializedName("data")
//    var data: List<userDetail>//camel case
//    )
//
//data class userDetail(
//    @SerializedName("id")
//    var useId:String,
//
//    @SerializedName("name")
//    var useName:List<userDetail>
//
//)
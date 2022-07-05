package com.example.kotlin_demo.data

import com.example.kotlin_demo.domain.ApiInterface
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UserService {

 private val BASE_URL = "https://raw.githubusercontent.com"
    private val api : ApiInterface
    init {
        api = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)
    }
    fun getUserDetails(): Single<List<CountryModel>>{
        return api.getCountries()
    }
}
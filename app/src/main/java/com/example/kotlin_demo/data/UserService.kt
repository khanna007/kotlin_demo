package com.example.kotlin_demo.data

import com.example.kotlin_demo.domain.ApiInterface
import com.example.kotlin_demo.presentation.MainActivity
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

class UserService {

// private val BASE_URL = "https://private-b8fd6-baseproject2.apiary-mock.com"
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
//package com.example.kotlin_demo.data.network
//
//import com.example.kotlin_demo.common.Constants
//import com.example.kotlin_demo.data.CountryModel
//import com.example.kotlin_demo.data.api.CountryInterface
//import io.reactivex.Single
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.converter.gson.GsonConverterFactory
//
//class UserService {
//
//
//    private val api : CountryInterface
//    init {
//        api = Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .baseUrl(Constants.BASE_URL)
//            .build()
//            .create(CountryInterface::class.java)
//    }
//
//    fun getUserDetails(): Single<List<CountryModel>>{
//        return api.getCountries()
//    }
//}
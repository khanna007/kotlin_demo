package com.example.kotlin_demo.data.remote

 import com.example.kotlin_demo.data.api.CountryInterface
 import com.example.kotlin_demo.data.mapper.CountryMapper
 import com.example.kotlin_demo.domain.model.Country
 import com.example.kotlin_demo.domain.repository.CountryRepository
import io.reactivex.Single
import javax.inject.Inject

class CountryImplementation @Inject constructor(private  val api: CountryInterface) :CountryRepository{

    override  fun getCountries(): Single<List<Country>> {
        return  CountryMapper().countryModelMapper(api.getCountries())
    }
}

package com.example.kotlin_demo.domain.use_case

import com.example.kotlin_demo.data.CountryModel
import com.example.kotlin_demo.domain.repository.CountryRepository
import io.reactivex.Single
import javax.inject.Inject


class GetCountryUseCase @Inject constructor(private val countryRepository: CountryRepository) {

      fun execute(): Single<List<CountryModel>> {
        return countryRepository.getCountries()
      }
}
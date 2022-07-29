package com.example.kotlin_demo.domain.use_case

import com.example.kotlin_demo.domain.model.Country
import com.example.kotlin_demo.domain.repository.CountryRepository
import io.reactivex.Single
import javax.inject.Inject


class GetCountryUseCase @Inject constructor(private val countryRepository: CountryRepository) {

      fun execute(): Single<List<Country>> {
        return countryRepository.getCountries()
      }
}
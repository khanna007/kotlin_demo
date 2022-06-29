package com.example.kotlin_demo.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.kotlin_demo.R
import com.example.kotlin_demo.data.CountryModel
import com.example.kotlin_demo.domain.ApiInterface
import kotlinx.android.synthetic.main.fragment_first.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            var BASE_URL = "https://private-b8fd6-baseproject2.apiary-mock.com"
                val retrofit = Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
        val service = retrofit.create(ApiInterface::class.java);
        // if we pass hogh order function or interface use :: and interface passs kr diya fucntion k ander
        val request =service.listCountries()
        val result = request.execute().body()
        Timber.d("result $result")

        request.enqueue(object : Callback<List<CountryModel>> {
            override fun onResponse(call: Call<List<CountryModel>>, response: Response<List<CountryModel>>) {
               Timber.d("hello$response")
                val allCountry = response.body()
                for (c in allCountry!!)
                    Timber.d(
                        MainActivity::class.simpleName,
                        "NAME: ${c.name} "
                    )
            }
            override fun onFailure(call: Call<List<CountryModel>>, t: Throwable) {
                Timber.i(MainActivity::class.simpleName, "on FAILURE!!!!")
            }

        });// response

        button_first.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}
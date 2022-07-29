package com.example.kotlin_demo.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_demo.presentation.viewModdel.ListViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_demo.databinding.FragmentFirstBinding
import com.example.kotlin_demo.domain.model.Country
import com.example.kotlin_demo.presentation.adapters.UserViewAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CountryFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding
    lateinit var userViewAdapter: UserViewAdapter
    lateinit var viewModel: ListViewModel
    private val countriesAdapter = UserViewAdapter(arrayListOf(), this::onClick)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.getRoot()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.refresh()
        userViewAdapter = countriesAdapter
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = userViewAdapter
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.users.observe(this, Observer { countries ->
            binding.recyclerView.visibility = View.VISIBLE
            countriesAdapter.updateUserList(countries)
        })

        viewModel.userLoadError.observe(this, Observer { isError ->
            binding.listError.visibility = if (isError) View.VISIBLE else View.GONE
        })

        viewModel.userLoading.observe(this, Observer { isLoading ->
            binding.loadingView.visibility = if (isLoading) View.VISIBLE else View.GONE
            if (isLoading) {
                binding.listError.visibility = View.GONE
                binding.recyclerView.visibility = View.GONE
            }
        })
    }

    fun onClick(countryModel: Country) {
//        dbCountrydow.insert(CountryMapper().transferDomailModelToLocalModel(countryModel))
//        println("postion$position")
    }
}
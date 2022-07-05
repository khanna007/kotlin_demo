package com.example.kotlin_demo.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.kotlin_demo.R
import kotlinx.android.synthetic.main.fragment_first.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_demo.view_model.ListViewModel
import androidx.lifecycle.Observer
import com.example.kotlin_demo.data.CountryModel
import com.example.kotlin_demo.data.local.CountryDao
import com.example.kotlin_demo.data.local.countryNoteDb
import com.example.kotlin_demo.presentation.adapters.UserViewAdapter

class FirstFragment : Fragment()  {
    lateinit  var dbCountrydow : CountryDao
    lateinit var userViewAdapter: UserViewAdapter
    lateinit var viewModel: ListViewModel
    private val countriesAdapter = UserViewAdapter(arrayListOf(),this::onClick)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dbCountrydow = countryNoteDb.getInstance(context!!).countryDow()
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()
        userViewAdapter = countriesAdapter // context mtlb device ka access milega
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter =userViewAdapter
        }
        button_first.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.users.observe(this, Observer {countries ->
            countries?.let {
                recycler_view.visibility = View.VISIBLE
                countriesAdapter.updateUserList(it) }
        })

        viewModel.userLoadError.observe(this, Observer { isError ->
            isError?.let { list_error.visibility = if(it) View.VISIBLE else View.GONE }
        })

        viewModel.userLoading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    list_error.visibility = View.GONE
                    recycler_view.visibility = View.GONE
                }
            }
        })
    }

      fun onClick(countryModel: CountryModel ) {
//        dbCountrydow.insert(CountryMapper().transferDomailModelToLocalModel(countryModel))
//        println("postion$position")
    }
}
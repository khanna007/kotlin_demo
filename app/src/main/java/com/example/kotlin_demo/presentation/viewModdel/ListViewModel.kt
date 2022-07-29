package com.example.kotlin_demo.presentation.viewModdel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_demo.domain.model.Country
import com.example.kotlin_demo.domain.use_case.GetCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getCountryUseCase: GetCountryUseCase) :
    ViewModel() {

    private val disposable = CompositeDisposable()  // close or clear the variable
    val users = MutableLiveData<List<Country>>()
    val userLoadError = MutableLiveData<Boolean>()
    val userLoading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchUserdata()
    }

    private fun fetchUserdata() {
        try {
            getCountryUseCase.execute()
                .subscribe({
                    users.value = it
                    userLoadError.value = false
                    userLoading.value = false
                }, {
                    userLoadError.value = true
                }).collect()
        } catch (e: Exception) {
            userLoadError.value = false
            println(e)
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
    private fun Disposable.collect()=disposable.add(this)

}




//{
//    override fun onSuccess(t: List<Country>) {
//
//        userLoadError.value = false
//        userLoading.value = false
//    }
//
//    override fun onError(e: Throwable) {
//        println("exception $e")
//        userLoadError.value = true
//        userLoading.value = true
//    }
//}
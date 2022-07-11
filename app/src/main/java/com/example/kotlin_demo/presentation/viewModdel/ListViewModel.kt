package com.example.kotlin_demo.presentation.viewModdel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_demo.data.CountryModel
import com.example.kotlin_demo.domain.use_case.GetCountryUseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val getCountryUseCase: GetCountryUseCase) : ViewModel() {

    private val disposable = CompositeDisposable()  // close or clear the variable
    val users = MutableLiveData<List<CountryModel>>()
    val userLoadError = MutableLiveData<Boolean>()
    val userLoading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchUserdata()
    }
    private fun fetchUserdata(){
        userLoading.value = true
        disposable.add(
            getCountryUseCase.execute().subscribeOn(
                Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).
                subscribeWith(object : DisposableSingleObserver<List<CountryModel>>(){
                override fun onSuccess(t: List<CountryModel>) {
                    users.value =  t
                    userLoadError.value = false
                    userLoading.value = false
                }

                override fun onError(e: Throwable) {
                    userLoadError.value = true
                    userLoading.value = true
                }
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
package com.example.kotlin_demo.presentation.view_model

 import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlin_demo.data.CountryModel
 import com.example.kotlin_demo.data.repository.UserService

 import io.reactivex.android.schedulers.AndroidSchedulers
 import io.reactivex.disposables.CompositeDisposable
 import io.reactivex.observers.DisposableSingleObserver
 import io.reactivex.schedulers.Schedulers


class ListViewModel : ViewModel() {

    private val userSerice = UserService()
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
            userSerice.getUserDetails().subscribeOn(
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
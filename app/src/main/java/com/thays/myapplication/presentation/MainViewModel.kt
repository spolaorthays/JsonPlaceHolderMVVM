package com.thays.myapplication.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.thays.myapplication.data.local.Photo
import com.thays.myapplication.domain.MainContract
import com.thays.myapplication.utils.ManageThreads
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

class MainViewModel(
    private val interactor: MainContract.Interactor,
    private val scheduler: ManageThreads
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    val photoList = MutableLiveData<List<Photo>>()

    fun getPhotosFromInteractor() {
        compositeDisposable.add(
            interactor.getPhotosFromRepository()
                .subscribeOn(scheduler.io)
                .observeOn(scheduler.main)
                .subscribeBy (
                    onSuccess = {
                        photoList.value = it
                    },
                    onError = {
                        println("Erro ao consultar a API: ${it.message}")
                    }
                )
        )
    }
}
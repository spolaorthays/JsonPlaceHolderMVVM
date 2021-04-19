package com.thays.myapplication.domain

import com.thays.myapplication.data.local.Photo
import io.reactivex.Single

class MainInteractor(private val repository: MainContract.Repository) : MainContract.Interactor {

    override fun getPhotosFromRepository(): Single<List<Photo>> =
        repository.getPhotosFromService()

}
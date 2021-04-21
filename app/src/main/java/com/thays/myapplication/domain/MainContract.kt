package com.thays.myapplication.domain

import com.thays.myapplication.data.local.Photo
import io.reactivex.Single

interface MainContract {

    interface Interactor {
        fun getPhotosFromRepository(): Single<List<Photo>>
    }

    interface Repository {
        fun getPhotosFromService(): Single<List<Photo>>
    }
}
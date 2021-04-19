package com.thays.myapplication.data

import com.thays.myapplication.domain.MainContract
import com.thays.myapplication.data.local.Photo
import com.thays.myapplication.data.remote.PhotoService
import io.reactivex.Single

class MainRepository(private val service: PhotoService) : MainContract.Repository {

    override fun getPhotosFromService(): Single<List<Photo>> =
        service.getPhotos()

}
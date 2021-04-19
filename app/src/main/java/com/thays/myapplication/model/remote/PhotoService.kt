package com.thays.myapplication.model.remote

import com.thays.myapplication.model.local.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface PhotoService {

    @GET("photos")
    fun getPhotos(): Single<List<Photo>>
}
package com.thays.myapplication.data.remote

import com.thays.myapplication.data.local.Photo
import io.reactivex.Single
import retrofit2.http.GET

interface PhotoService {

    @GET("photos")
    fun getPhotos(): Single<List<Photo>>
}
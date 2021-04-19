package com.thays.myapplication.utils

import android.app.Application
import com.thays.myapplication.data.remote.Network
import com.thays.myapplication.presentation.MainViewModel

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Network.initialize(this)
    }
}
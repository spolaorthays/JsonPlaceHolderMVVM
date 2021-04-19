package com.thays.myapplication.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thays.myapplication.presentation.MainViewModel

//class ViewModelFactory(private val mApplication: CustomApplication) : ViewModelProvider.Factory {
//
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            return when(modelClass) {
//                DataViewModel::class.java -> DataViewModel(mApplication)
//
//                else -> throw IllegalArgumentException("Unknown ViewModel class")
//            } as T
//        }
//
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return when(modelClass) {
//            MainViewModel::class.java -> MainViewModel(mApplication)
//        }
//    }
//
//}
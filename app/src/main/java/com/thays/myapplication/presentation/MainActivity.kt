package com.thays.myapplication.presentation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.thays.myapplication.R
import com.thays.myapplication.data.MainRepository
import com.thays.myapplication.data.remote.Network
import com.thays.myapplication.data.remote.PhotoService
import com.thays.myapplication.databinding.ActivityMainBinding
import com.thays.myapplication.domain.MainInteractor
import com.thays.myapplication.utils.ManageThreads
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class DataBindingHelper: AppCompatActivity() {

    inline fun <reified T: ViewDataBinding> Activity.bind(@LayoutRes layout: Int, noinline block: T.() -> Unit): T {
        return DataBindingUtil.setContentView<T>(this, layout).apply {
            block.invoke(this)
        }
    }

}

class MainActivity : DataBindingHelper() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by lazy {
        MainViewModel(
            MainInteractor(
                MainRepository(
                    Network.provideService(
                        PhotoService::class.java))),
            ManageThreads(AndroidSchedulers.mainThread(), Schedulers.io()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = bind(R.layout.activity_main) {
            viewmodel = viewModel
            lifecycleOwner = this@MainActivity
        }

        viewModel.photoList.observeForever { listPhoto ->
            //seta a lista no recyclerView aqui?
        }
    }

}
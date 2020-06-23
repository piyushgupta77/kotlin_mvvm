package com.kotlin.mykotlinproj.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kotlin.mykotlinproj.R
import com.kotlin.mykotlinproj.databinding.ActivityMainBinding
import com.kotlin.mykotlinproj.viewmodel.RepoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val TAG:String = "MainActivity"
    private lateinit var viewBinding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewBinding.viewmodel= ViewModelProvider(this).get(RepoViewModel::class.java)

        viewBinding.lifecycleOwner = this
        // call co routine
        GlobalScope.launch(Dispatchers.Main) {
            viewBinding.viewmodel!!.getRepos()  //viewModel should never be null
        }

        viewBinding.viewmodel?.resultItems?.observe(this, Observer {
            Log.d(TAG, "" + it.size)
        })

        viewBinding.viewmodel?.isEmptyData?.observe(this, Observer {
            Log.d(TAG, "Empty data " + it)
        })

        viewBinding.viewmodel?.isDataLoading?.observe(this, Observer {
            Log.d(TAG, "Empty data " + it)
        })
    }
}
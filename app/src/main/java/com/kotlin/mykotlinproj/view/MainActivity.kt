package com.kotlin.mykotlinproj.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kotlin.mykotlinproj.R
import com.kotlin.mykotlinproj.databinding.ActivityMainBinding
import com.kotlin.mykotlinproj.viewmodel.RepoViewModel

class MainActivity : AppCompatActivity() {

    private val TAG:String = "MainActivity"
    private lateinit var viewBinding : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewBinding.viewmodel = ViewModelProviders.of(this@MainActivity).get(RepoViewModel::class.java)
        viewBinding.lifecycleOwner = this
        viewBinding.viewmodel!!.getRepos()  //viewModel should never be null

        viewBinding.viewmodel?.resultItems?.observe(this, Observer {
            Log.d(TAG, "" + it.size)
        })

        viewBinding.viewmodel?.isEmptyData?.observe(this, Observer {
            Log.d(TAG, "Empty data " + it)
        })
    }
}
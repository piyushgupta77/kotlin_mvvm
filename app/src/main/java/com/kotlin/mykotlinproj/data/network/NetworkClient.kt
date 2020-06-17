package com.kotlin.mykotlinproj.data.network

import com.google.gson.GsonBuilder
import com.kotlin.mykotlinproj.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {

    private var retrofit: Retrofit? = null

    fun <T> create(api: Class<T>): T {
        retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient())
            .build()
        return retrofit!!.create(api)
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }
}
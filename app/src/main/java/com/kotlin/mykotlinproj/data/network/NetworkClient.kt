package com.kotlin.mykotlinproj.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

class NetworkClient @Inject constructor(private val retrofit: Retrofit) {

    fun <T> create(api: Class<T>): T {
        return retrofit.create(api)
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }
}
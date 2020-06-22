package com.kotlin.mykotlinproj.di

import com.kotlin.mykotlinproj.Constants
import com.kotlin.mykotlinproj.data.network.NetworkClient
import com.kotlin.mykotlinproj.data.repo.GithubRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepoModule {
    @Provides
    @Singleton
    fun provideRepository(networkClient: NetworkClient): GithubRepository {
        return GithubRepository(networkClient)
    }

    @Provides
    fun provideNetworkClient(retrofit: Retrofit): NetworkClient {
        return NetworkClient(retrofit)
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

}
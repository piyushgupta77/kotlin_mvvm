package com.kotlin.mykotlinproj.data.repo

import android.util.Log
import com.kotlin.mykotlinproj.data.model.GitResponse
import com.kotlin.mykotlinproj.data.network.GithubApi
import com.kotlin.mykotlinproj.data.network.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class GithubRepository @Inject constructor(private val networkClient: NetworkClient) {

    suspend fun getRepo(): GitResponse? {
        var gitResponse: GitResponse? = null
        withContext(Dispatchers.IO) {
            Log.d("GithubRepository", "inside coroutine thread " + Thread.currentThread().name)
            val response: Response<GitResponse> =
                networkClient.create(GithubApi::class.java).getRepo().execute()

            if (response.isSuccessful) {
                gitResponse = response.body()
            }
        }
        return gitResponse
    }
}
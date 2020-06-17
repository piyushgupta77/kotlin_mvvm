package com.kotlin.mykotlinproj.data.repo

import com.kotlin.mykotlinproj.data.model.GitResponse
import com.kotlin.mykotlinproj.data.network.GithubApi
import com.kotlin.mykotlinproj.data.network.NetworkClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRepository {

    companion object {
        val INSTANCE: GithubRepository =
            GithubRepository()
    }

    fun getRepo(resultLambda: (success: Boolean, response: GitResponse?) -> Unit) {
        NetworkClient().create(GithubApi::class.java).getRepo()
            .enqueue(object : Callback<GitResponse> {
                override fun onResponse(call: Call<GitResponse>, response: Response<GitResponse>) {
                    resultLambda(true, response.body()!!)
                }

                override fun onFailure(call: Call<GitResponse>, t: Throwable) {
                    resultLambda(false, null)
                }
            })
    }
}
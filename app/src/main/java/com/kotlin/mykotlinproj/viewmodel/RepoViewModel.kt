package com.kotlin.mykotlinproj.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.mykotlinproj.data.model.GitItem
import com.kotlin.mykotlinproj.data.model.GitResponse
import com.kotlin.mykotlinproj.data.repo.GithubRepository

class RepoViewModel @ViewModelInject constructor(private val githubRepository: GithubRepository) : ViewModel() {

    private val TAG: String = "RepoViewModel"
    val isDataLoading = MutableLiveData<Boolean>().apply { value = false }
    val isEmptyData = MutableLiveData<Boolean>().apply { value = true }
    val resultItems = MutableLiveData<List<GitItem>>()

    suspend fun getRepos() {
        Log.d(TAG, "thread: " + Thread.currentThread().name)

        isDataLoading.value = true

        val gitResponse: GitResponse? = githubRepository.getRepo()
        isDataLoading.value = false

        if (gitResponse != null) {
            resultItems.postValue(gitResponse.items)
            isEmptyData.postValue(false)
        } else {
            isEmptyData.postValue(true)
        }
    }
}
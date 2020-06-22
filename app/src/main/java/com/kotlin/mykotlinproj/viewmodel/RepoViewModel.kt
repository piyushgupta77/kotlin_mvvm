package com.kotlin.mykotlinproj.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.mykotlinproj.data.model.Item
import com.kotlin.mykotlinproj.data.repo.GithubRepository
import javax.inject.Inject

class RepoViewModel @ViewModelInject constructor(private val githubRepository: GithubRepository) : ViewModel() {

    private val TAG: String = "RepoViewModel"
    val isDataLoading = MutableLiveData<Boolean>().apply { value = false }
    val isEmptyData = MutableLiveData<Boolean>().apply { value = true }
    val resultItems = MutableLiveData<List<Item>>()

    fun getRepos() {
        Log.d(TAG ,"thread: " + Thread.currentThread().name);
        isDataLoading.value = true
        githubRepository.getRepo { success, response ->
            isDataLoading.value = false
            if (success) {
                resultItems.postValue(response?.items);
                isEmptyData.postValue(false)
            } else {
                isEmptyData.postValue(true)
            }
        }
    }
}
package com.kotlin.mykotlinproj.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kotlin.mykotlinproj.data.model.GitResponse
import com.kotlin.mykotlinproj.data.model.Item
import com.kotlin.mykotlinproj.data.repo.GithubRepository
import com.kotlin.mykotlinproj.view.MainActivity

class RepoViewModel : ViewModel() {
    val isDataLoading = MutableLiveData<Boolean>().apply { value = false }

    val isEmptyData = MutableLiveData<Boolean>().apply { value = true }

    val resultItems = MutableLiveData<List<Item>>()

    fun getRepos() {
        isDataLoading.value = true
        GithubRepository.INSTANCE.getRepo { success, response ->
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
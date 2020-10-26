package com.kotlin.mykotlinproj.view

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.mykotlinproj.BR
import com.kotlin.mykotlinproj.data.model.GitItem

class RepoViewHolder(private val dataBinding:ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root) {

    fun setUp(gitItem : GitItem) {
        // inform data binding to use param gitItem for binding with its variable itemData(defined in row_repo_list_item.xml)
        dataBinding.setVariable(BR.itemData, gitItem)
    }
}
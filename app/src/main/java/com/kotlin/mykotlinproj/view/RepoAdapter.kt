package com.kotlin.mykotlinproj.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.mykotlinproj.data.model.GitItem
import com.kotlin.mykotlinproj.databinding.RowRepoListItemBinding

class RepoAdapter(private val items: List<GitItem>) : RecyclerView.Adapter<RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val dataBinding =
            RowRepoListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoViewHolder(dataBinding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.setUp(items[position])
    }
}
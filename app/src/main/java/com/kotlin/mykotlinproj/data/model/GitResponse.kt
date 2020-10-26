package com.kotlin.mykotlinproj.data.model

data class GitResponse(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<GitItem>
)
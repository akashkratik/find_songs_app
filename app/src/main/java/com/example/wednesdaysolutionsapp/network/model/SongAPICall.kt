package com.example.wednesdaysolutionsapp.network.model

data class SongAPICall(
    val resultCount: Int,
    val results: List<Result>
)
package com.example.wednesdaysolutionsapp.network.model

data class Result(
    val artistName: String,
    val artistViewUrl: String,
    val artworkUrl100: String,
    val artworkUrl30: String,
    val artworkUrl60: String,
    val artworkUrl600: String,
    val collectionName: String,
    val collectionViewUrl: String,
    val kind: String,
    val primaryGenreName: String,
    val releaseDate: String,
    val trackCount: Int,
    val trackName: String,
    val trackViewUrl: String
)
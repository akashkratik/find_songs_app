package com.example.wednesdaysolutionsapp.network

import com.example.wednesdaysolutionsapp.network.model.SongAPICall
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://itunes.apple.com/"

interface SongsNetwork {
    @GET("search?")
    fun getSong(@Query("term")searchString: String): Call<SongAPICall>

}
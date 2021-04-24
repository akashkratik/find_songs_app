package com.example.wednesdaysolutionsapp.repository

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.wednesdaysolutionsapp.network.BASE_URL
import com.example.wednesdaysolutionsapp.network.SongsNetwork
import com.example.wednesdaysolutionsapp.network.model.Result
import com.example.wednesdaysolutionsapp.network.model.SongAPICall
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchActivityRepository(val application: Application) {

    val showProgress = MutableLiveData<Boolean>()
    val songList = MutableLiveData<List<Result>>()

    fun changeState(){
        showProgress.value = !(showProgress.value != null && showProgress.value!!)
    }

    fun searchSong(searchString: String){
        showProgress.value = true


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(SongsNetwork::class.java)

        service.getSong(searchString).enqueue(object : Callback<SongAPICall>{
            override fun onFailure(call: Call<SongAPICall>, t: Throwable) {
                showProgress.value = false
                Log.d("SearchRepository", "error", t)
                Toast.makeText(application, "Some error occurred!", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onResponse(call: Call<SongAPICall>, response: Response<SongAPICall>) {
//                Log.d("SearchRepository", "Response : ${Gson().toJson(response.body())}")
                if(response.code() == 200) {
                    val songAPICall = response.body()!!
                    Log.d("SearchRepository", songAPICall.resultCount.toString())
                    Log.d("SearchRepository2", searchString)
                    for(song in songAPICall.results){
                        Log.d("SearchRepository", song.artistName)
                    }
                }
                songList.value = response.body()?.results
                showProgress.value = false
            }

        })
    }

}
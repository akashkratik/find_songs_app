package com.example.wednesdaysolutionsapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.wednesdaysolutionsapp.network.model.Result
import com.example.wednesdaysolutionsapp.repository.SearchActivityRepository

class SearchActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = SearchActivityRepository(application)
    val showProgress: LiveData<Boolean>
    val songList: LiveData<List<Result>>
    init{
        this.showProgress = repository.showProgress
        this.songList = repository.songList

    }

    fun changeState(){
        repository.changeState()
    }

    fun searchSong(searchString: String){
        repository.searchSong(searchString)
    }

}
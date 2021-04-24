package com.example.wednesdaysolutionsapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.wednesdaysolutionsapp.repository.DetailsActivityRepository

class DetailsActivityViewModel(application: Application): AndroidViewModel(application) {
    val repository = DetailsActivityRepository(application)
}
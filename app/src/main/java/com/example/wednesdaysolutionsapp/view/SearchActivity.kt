package com.example.wednesdaysolutionsapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.wednesdaysolutionsapp.R
import com.example.wednesdaysolutionsapp.adapter.SongAdapter
import com.example.wednesdaysolutionsapp.viewModel.SearchActivityViewModel
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchActivityViewModel
    private lateinit var adapter: SongAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        viewModel = ViewModelProvider(this).get(SearchActivityViewModel::class.java)
        iv_search.setOnClickListener {
//            viewModel.changeState()
            if(et_search.text!!.isNotEmpty()){
                viewModel.searchSong(et_search.text.toString())
            }
        }

        viewModel.showProgress.observe(this, Observer {
            if(it){
                search_progress.visibility = VISIBLE
            }else{
                search_progress.visibility = GONE
            }
        })

        viewModel.songList.observe(this, Observer {
            adapter.setSonglist(it)
        })
        adapter = SongAdapter(this)
        rv_search_result.adapter = adapter
    }
}
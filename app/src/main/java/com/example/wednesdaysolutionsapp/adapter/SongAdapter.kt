package com.example.wednesdaysolutionsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wednesdaysolutionsapp.R
import com.example.wednesdaysolutionsapp.network.model.Result
import kotlinx.android.synthetic.main.rv_layout.view.*

class SongAdapter(private val context: Context)
    :RecyclerView.Adapter<SongAdapter.ViewHolder>(){

    private var list: List<Result> = ArrayList()
    fun setSonglist(list: List<Result>){
        this.list = list
        notifyDataSetChanged()
    }
    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val artistName = v.tv_artist_name
        val songName = v.tv_song_name
        val ivSongImage = v.iv_song_image
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.rv_layout,parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.songName.text = list[position].trackName
        holder.artistName.text = list[position].artistName
        Glide.with(context)
            .load(list[position].artworkUrl100)
            .into(holder.ivSongImage)
    }
}
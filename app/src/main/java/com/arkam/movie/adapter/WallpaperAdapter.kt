package com.arkam.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.arkam.core.constant.Constant
import com.arkam.movie.databinding.ItemWallpaperBinding

class WallpaperAdapter: RecyclerView.Adapter<WallpaperAdapter.WallpaperViewHolder>() {

    val listWallpaper = arrayListOf<String>()

    fun setData(list: List<String>){
        listWallpaper.clear()
        listWallpaper.addAll(list)
    }

    class WallpaperViewHolder(val binding: ItemWallpaperBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = WallpaperViewHolder(
        ItemWallpaperBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: WallpaperViewHolder, position: Int) {
        holder.apply {

            Glide.with(itemView.context)
                .load(Constant.IMAGE_BASE_URL+listWallpaper[position])
                .into(binding.imgWallpaper)
        }
    }

    override fun getItemCount() = listWallpaper.size
}
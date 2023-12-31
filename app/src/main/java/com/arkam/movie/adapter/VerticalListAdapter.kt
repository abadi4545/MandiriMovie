package com.arkam.movie.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.arkam.core.constant.Constant
import com.arkam.core.domain.model.movie.Movie
import com.arkam.core.domain.model.tv.Tv
import com.arkam.movie.`interface`.OnItemClickCallback
import com.arkam.movie.databinding.ItemVerticalMovieBinding
import com.arkam.movie.utils.HelperFunction

class VerticalListAdapter<T>: RecyclerView.Adapter<VerticalListAdapter.VerticalViewholder>() {

    val listMovie = ArrayList<T>()

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    fun setData(list: List<T>?){
        if(list == null) return
        listMovie.clear()
        listMovie.addAll(list)
    }

    class VerticalViewholder(val binding: ItemVerticalMovieBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= VerticalViewholder(
        ItemVerticalMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VerticalViewholder, position: Int) {
        holder.binding.apply {
            when(listMovie[position]){
                is Movie -> {
                    with(listMovie[position] as Movie){
                        tvTitle.text = title
                        tvGenre.text = HelperFunction.genreComaFormatter(genre)
                        HelperFunction.setUpRatingStars(this@apply, voteAverage)
                        Glide.with(imgPoster.context)
                            .load(Constant.IMAGE_BASE_URL+posterPath)
                            .apply(RequestOptions())
                            .override(300, 300)
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .priority(Priority.HIGH)
                            .into(imgPoster)

                        holder.itemView.setOnClickListener {
                            onItemClickCallback?.onItemClicked(id)
                        }
                    }
                }
                is Tv -> {
                    with(listMovie[position] as Tv){
                        tvTitle.text = name
                        tvGenre.text = HelperFunction.genreComaFormatter(genre)
                        HelperFunction.setUpRatingStars(this@apply, voteAverage)
                        Glide.with(imgPoster.context)
                            .load(Constant.IMAGE_BASE_URL+posterPath)
                            .apply(RequestOptions())
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .priority(Priority.HIGH)
                            .into(imgPoster)

                        holder.itemView.setOnClickListener {
                            onItemClickCallback?.onItemClicked(id)
                        }
                    }
                }
            }

        }


    }

    override fun getItemCount() = listMovie.size
}
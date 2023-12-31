package com.arkam.movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.arkam.core.constant.Constant
import com.arkam.core.domain.model.detail.Actor
import com.arkam.movie.databinding.ItemCreditDetailBinding

class ActorAdapter: RecyclerView.Adapter<ActorAdapter.MyViewHolder>()  {
    private val listCredit = ArrayList<Actor>()

    class MyViewHolder(val binding: ItemCreditDetailBinding): RecyclerView.ViewHolder(binding.root)

    fun setData(list: List<Actor>?){
        if (list == null) return
        listCredit.clear()
        listCredit.addAll(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= MyViewHolder(
        ItemCreditDetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            tvName.text = listCredit[position].name
            tvCharacter.text = listCredit[position].character
            Glide.with(imgProfileCredit.context)
                .load(Constant.IMAGE_BASE_URL+listCredit[position].profilePath)
                .apply(RequestOptions())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH)
                .into(imgProfileCredit)
        }
    }

    override fun getItemCount() = listCredit.size
}
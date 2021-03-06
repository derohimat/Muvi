package com.andriiginting.favorite.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andriiginting.favorite.BuildConfig
import com.andriiginting.favorite.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_favorite_component.view.*

class MuviFavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun inflate(parent: ViewGroup): MuviFavoriteViewHolder {
            return MuviFavoriteViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_favorite_component, parent, false)
            )
        }
    }

    fun bind(url: String) {
        Glide.with(itemView.context)
            .load("${BuildConfig.IMAGE_BASE_URL}$url")
            .into(itemView.ivPoster)
    }
}
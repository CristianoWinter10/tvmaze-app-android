package com.winterprojects.tvmazeapp.presentation.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.winterprojects.tvmazeapp.common.helpers.OnItemClickListener
import com.winterprojects.tvmazeapp.databinding.ItemShowFavoriteBinding
import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel

class FavoriteAdapter(
    private val itemClickListener: OnItemClickListener<FavoriteShowModel>,
    private val onRemoveFavoriteItemClickListener: OnRemoveFavoriteItemClickListener
) :
    ListAdapter<FavoriteShowModel, FavoriteAdapter.FavoriteVideoHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteVideoHolder {
        val binding =
            ItemShowFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteVideoHolder(binding, itemClickListener, onRemoveFavoriteItemClickListener)
    }

    override fun onBindViewHolder(holder: FavoriteVideoHolder, position: Int) {
        holder.bind(position, getItem(position))
    }

    class FavoriteVideoHolder(
        private val binding: ItemShowFavoriteBinding,
        private val itemClickListener: OnItemClickListener<FavoriteShowModel>,
        private val onRemoveFavoriteItemClickListener: OnRemoveFavoriteItemClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, favoriteShowModel: FavoriteShowModel) {
            binding.favoriteShow = favoriteShowModel

            binding.buttonFavorite.setOnClickListener {
                onRemoveFavoriteItemClickListener.onRemoveFavoriteItemClickListener(position, favoriteShowModel)
            }

            this.itemView.setOnClickListener {
                itemClickListener.onItemClick(favoriteShowModel)
            }
        }


    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<FavoriteShowModel>() {
            override fun areItemsTheSame(oldItem: FavoriteShowModel, newItem: FavoriteShowModel): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: FavoriteShowModel, newItem: FavoriteShowModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}


package com.winterprojects.tvmazeapp.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.winterprojects.tvmazeapp.common.helpers.OnItemClickListener
import com.winterprojects.tvmazeapp.databinding.ItemShowBinding
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel

class ShowAdapter(
    private val itemClickListener: OnItemClickListener<TvShowModel>
) :
    ListAdapter<TvShowModel, ShowAdapter.ShowVideoHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowVideoHolder {
        val binding =
            ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowVideoHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: ShowVideoHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ShowVideoHolder(
        private val binding: ItemShowBinding,
        private val itemClickListener: OnItemClickListener<TvShowModel>
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowModel: TvShowModel) {
            binding.show = tvShowModel.show

            this.itemView.setOnClickListener {
                itemClickListener.onItemClick(tvShowModel)
            }
        }


    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<TvShowModel>() {
            override fun areItemsTheSame(oldItem: TvShowModel, newItem: TvShowModel): Boolean {
                return oldItem.show.id == newItem.show.id
            }
            override fun areContentsTheSame(oldItem: TvShowModel, newItem: TvShowModel): Boolean {
                return oldItem.show == newItem.show
            }
        }
    }
}


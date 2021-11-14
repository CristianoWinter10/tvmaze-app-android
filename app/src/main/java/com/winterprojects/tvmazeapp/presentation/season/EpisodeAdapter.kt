package com.winterprojects.tvmazeapp.presentation.season

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.winterprojects.tvmazeapp.common.helpers.OnItemClickListener
import com.winterprojects.tvmazeapp.databinding.ItemEpisodeBinding
import com.winterprojects.tvmazeapp.domain.episodes.models.EpisodeModel

class EpisodeAdapter(private val itemClickListener: OnItemClickListener<EpisodeModel>) :
    ListAdapter<EpisodeModel, EpisodeAdapter.EpisodeHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeHolder {
        val binding =
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: EpisodeHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class EpisodeHolder(
        private val binding: ItemEpisodeBinding,
        private val itemClickListener: OnItemClickListener<EpisodeModel>
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: EpisodeModel) {
            binding.episode = episode

            this.itemView.setOnClickListener {
                itemClickListener.onItemClick(episode)
            }
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<EpisodeModel>() {
            override fun areItemsTheSame(oldItem: EpisodeModel, newItem: EpisodeModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: EpisodeModel, newItem: EpisodeModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}


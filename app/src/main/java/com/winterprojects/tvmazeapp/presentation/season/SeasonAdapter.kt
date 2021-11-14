package com.winterprojects.tvmazeapp.presentation.season

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.winterprojects.tvmazeapp.common.helpers.OnItemClickListener
import com.winterprojects.tvmazeapp.databinding.ItemSeasonBinding
import com.winterprojects.tvmazeapp.domain.episodes.models.EpisodeModel
import com.winterprojects.tvmazeapp.domain.season.SeasonModel

class SeasonAdapter(private val itemClickListener: OnItemClickListener<EpisodeModel>) :
    ListAdapter<SeasonModel, SeasonAdapter.SeasonHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeasonHolder {
        val binding =
            ItemSeasonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeasonHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: SeasonHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SeasonHolder(
        private val binding: ItemSeasonBinding,
        private val itemClickListener: OnItemClickListener<EpisodeModel>
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(season: SeasonModel) {
            binding.season = season
            binding.recyclerSeasonEpisodes.adapter = EpisodeAdapter(itemClickListener).apply {
                submitList(season.episodes)
            }
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<SeasonModel>() {
            override fun areItemsTheSame(oldItem: SeasonModel, newItem: SeasonModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: SeasonModel, newItem: SeasonModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}


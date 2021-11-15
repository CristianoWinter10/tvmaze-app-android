package com.winterprojects.tvmazeapp.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.winterprojects.tvmazeapp.common.helpers.OnItemClickListener
import com.winterprojects.tvmazeapp.databinding.ItemShowBinding
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel


class HomeShowAdapter(private val onItemClickListener: OnItemClickListener<ShowModel>) :
    PagingDataAdapter<ShowModel, HomeShowAdapter.ShowViewHolder>(diffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShowViewHolder {
        val binding = ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowViewHolder(binding, onItemClickListener)
    }

    class ShowViewHolder(
        private val binding: ItemShowBinding,
        private val onItemClickListener: OnItemClickListener<ShowModel>
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(show: ShowModel?) {
            show?.let {
                binding.show = show

                itemView.setOnClickListener {
                    onItemClickListener.onItemClick(show)
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ShowModel>() {
            override fun areItemsTheSame(oldItem: ShowModel, newItem: ShowModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ShowModel, newItem: ShowModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}
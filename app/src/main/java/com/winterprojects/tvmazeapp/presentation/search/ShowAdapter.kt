package com.winterprojects.tvmazeapp.presentation.search

import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.winterprojects.tvmazeapp.R
import com.winterprojects.tvmazeapp.common.helpers.OnItemClickListener
import com.winterprojects.tvmazeapp.databinding.ShowItemListBinding
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel

class ShowAdapter(val itemClickListener: OnItemClickListener<TvShowModel>) : ListAdapter<TvShowModel, ShowAdapter.ShowVideoHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowVideoHolder {
        val binding =
            ShowItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowVideoHolder(binding, itemClickListener)
    }

    override fun onBindViewHolder(holder: ShowVideoHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ShowVideoHolder(
        private val binding: ShowItemListBinding,
        private val itemClickListener: OnItemClickListener<TvShowModel>
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowModel: TvShowModel) {
            with(tvShowModel) {
                val context = binding.root.context

                binding.textViewTitle.text = show.name
                binding.textViewAverageScore.text =
                    show.rating?.average?.toString() ?: "$DEFAULT_VALUE_RATING"

                show.genres?.joinToString(", ") ?: context.getString(
                    R.string.no_information
                )

                binding.textViewAverageRuntime.text = show.averageRuntime?.let { runtime ->
                context.resources.getQuantityString(R.plurals.arg_minutes, runtime, runtime)
                } ?: getDefaultValueWhenThereIsNoInformation(
                    context
                )

                binding.textViewGenres.text = show.genres?.let {
                    if (it.isNotEmpty()) {
                        it.joinToString(", ")
                    } else {
                        getDefaultValueWhenThereIsNoInformation(context)
                    }
                } ?: getDefaultValueWhenThereIsNoInformation(context)

                show.image?.let {
                    binding.imageViewPoster.load(it.medium)
                }

                show.summary?.let {
                    binding.textViewSummary.text = getHandledSummaryHtmlText(it)
                } ?: getDefaultValueWhenThereIsNoInformation(context)

            }

            this.itemView.setOnClickListener {
                itemClickListener.onItemClick(tvShowModel)
            }
        }

        private fun getHandledSummaryHtmlText(it: String) =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Html.fromHtml(it, FROM_HTML_MODE_LEGACY)
            } else {
                Html.fromHtml(it)
            }

        private fun getDefaultValueWhenThereIsNoInformation(context: Context) =
            context.getString(
                R.string.no_information
            )
    }

    companion object {
        private const val DEFAULT_VALUE_RATING = 0.0

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


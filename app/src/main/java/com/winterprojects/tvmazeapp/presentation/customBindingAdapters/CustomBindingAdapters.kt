package com.winterprojects.tvmazeapp.presentation.customBindingAdapters

import android.os.Build
import android.text.Html
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.winterprojects.tvmazeapp.R

@BindingAdapter("handleTvShowRating")
fun TextView.handleTvShowRating(rating: Float?) {
    text = rating?.let {
        "$rating"
    } ?: context.resources.getString(R.string.not_applicable)
}

@BindingAdapter("handleTvShowSummary")
fun TextView.handleTvShowSummary(summary: String?) {
    text = summary?.let {
        getHandledSummaryHtmlText(it)
    } ?: context.getString(
        R.string.no_summary_informed
    )
}

@BindingAdapter("handleTvShowGenres")
fun TextView.handleTvShowGenres(genres: List<String>?) {
    text = genres?.let { currentGenre ->
        if (currentGenre.isNotEmpty()) {
            currentGenre.joinToString(", ")
        } else {
            context.getString(
                R.string.no_genre_informed
            )

        }
    } ?: context.getString(
        R.string.no_genre_informed
    )
}

@BindingAdapter("handleTvShowAverageRuntime")
fun TextView.handleTvShowAverageRuntime(averageRuntime: Int?) {
    text = averageRuntime?.let { runtime ->
        context.resources.getQuantityString(R.plurals.arg_minutes, runtime, runtime)
    } ?: context.getString(
        R.string.no_runtime_informed
    )
}

@BindingAdapter("loadImage")
fun ImageView.loadImage( url: String?) {
    load(url)
}

private fun getHandledSummaryHtmlText(it: String) =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(it, Html.FROM_HTML_MODE_LEGACY).trim()
    } else {
        Html.fromHtml(it).trim()
    }


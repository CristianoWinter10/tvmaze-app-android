package com.winterprojects.tvmazeapp.presentation.customBindingAdapters

import android.os.Build
import android.text.Html
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import com.google.android.material.button.MaterialButton
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

}@BindingAdapter("handleTvShowFavorite")
fun Button.handleTvShowFavorite(isFavorite: Boolean) {
    with(this as MaterialButton) {
        if(!isFavorite){
            this.setText(R.string.add)
            this.setTextColor(ContextCompat.getColor(context, R.color.honeydew_approx))
            this.setBackgroundColor(ContextCompat.getColor(context, R.color.color_favorite_status))
            this.icon = ContextCompat.getDrawable(context, R.drawable.ic_favorite_filled)
            this.iconTint = ContextCompat.getColorStateList(context, R.color.honeydew_approx)
            this.strokeColor = ContextCompat.getColorStateList(context, R.color.color_favorite_status)
        } else{
            this.setText(R.string.remove)
            this.setTextColor(ContextCompat.getColor(context, R.color.honeydew_approx))
            this.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            this.icon = ContextCompat.getDrawable(context, R.drawable.ic_favorite_border)
            this.iconTint = ContextCompat.getColorStateList(context, R.color.color_favorite_status)
            this.strokeColor = ContextCompat.getColorStateList(context, R.color.honeydew_approx)
        }
    }
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


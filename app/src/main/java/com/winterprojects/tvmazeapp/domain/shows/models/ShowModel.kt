package com.winterprojects.tvmazeapp.domain.shows.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShowModel(
    val averageRuntime: Int?,
    val ended: String?,
    val genres: List<String>?,
    val id: Int,
    val image: ImageModel?,
    val language: String?,
    val name: String,
    val officialSite: String?,
    val premiered: String?,
    val scheduleModel: ScheduleModel?,
    val rating: RatingModel?,
    val status: String?,
    val summary: String?,
    val weight: Int?,
    val _embedded: EmbeddedModel?,
    var isFavorite: Boolean = false
): Parcelable

fun ShowModel.toFavoriteShowModel(): FavoriteShowModel{
    return FavoriteShowModel(
        this.id,
        this.name,
        this.summary,
        this.image?.medium
    )
}
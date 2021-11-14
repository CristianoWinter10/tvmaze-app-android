package com.winterprojects.tvmazeapp.domain.episodes.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodeModel(
    val _links: LinksModel?,
    val airdate: String?,
    val airstamp: String?,
    val airtime: String?,
    val id: Int,
    val image: ImageModel?,
    val name: String?,
    val number: Int?,
    val rating: RatingModel?,
    val runtime: Int?,
    val season: Int,
    val summary: String?,
    val type: String?,
    val url: String?
): Parcelable
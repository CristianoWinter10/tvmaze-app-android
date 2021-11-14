package com.winterprojects.tvmazeapp.domain.shows.models

import android.os.Parcelable
import com.winterprojects.tvmazeapp.domain.cast.models.CastModel
import com.winterprojects.tvmazeapp.domain.episodes.models.EpisodeModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmbeddedModel(
    val cast: List<CastModel>?,
    val episodes: List<EpisodeModel>?
): Parcelable

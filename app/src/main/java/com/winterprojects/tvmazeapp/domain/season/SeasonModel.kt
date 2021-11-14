package com.winterprojects.tvmazeapp.domain.season

import android.os.Parcelable
import com.winterprojects.tvmazeapp.domain.episodes.models.EpisodeModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class SeasonModel(
    val id: Int,
    val episodes: List<EpisodeModel>
): Parcelable
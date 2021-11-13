package com.winterprojects.tvmazeapp.domain.shows.models

import com.winterprojects.tvmazeapp.domain.cast.models.CastModel
import com.winterprojects.tvmazeapp.domain.episodes.models.EpisodeModel

data class EmbeddedModel(
    val cast: List<CastModel>?,
    val episodes: List<EpisodeModel>?
)

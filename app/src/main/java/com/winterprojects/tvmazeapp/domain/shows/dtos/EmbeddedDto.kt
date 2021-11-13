package com.winterprojects.tvmazeapp.domain.shows.dtos

import com.winterprojects.tvmazeapp.domain.cast.dtos.CastDto
import com.winterprojects.tvmazeapp.domain.cast.dtos.toModel
import com.winterprojects.tvmazeapp.domain.episodes.dtos.EpisodeDto
import com.winterprojects.tvmazeapp.domain.episodes.dtos.toModel
import com.winterprojects.tvmazeapp.domain.shows.models.EmbeddedModel

data class EmbeddedDto(
    val cast: List<CastDto>?,
    val episodes: List<EpisodeDto>?
)

fun EmbeddedDto.toModel(): EmbeddedModel {
    return EmbeddedModel(
        this.cast?.map { it.toModel() }?.toList(),
        this.episodes?.map { it.toModel() }?.toList()
    )
}
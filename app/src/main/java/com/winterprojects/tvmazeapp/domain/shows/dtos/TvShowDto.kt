package com.winterprojects.tvmazeapp.domain.shows.dtos

import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel

data class TvShowDto(
    val score: Double?,
    val show: ShowDto
)

fun TvShowDto.toModel(): TvShowModel {
    return TvShowModel(
        this.score,
        this.show.toModel()
    )
}
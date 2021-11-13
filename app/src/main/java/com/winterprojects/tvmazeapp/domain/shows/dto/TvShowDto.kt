package com.winterprojects.tvmazeapp.domain.shows.dto

import com.winterprojects.tvmazeapp.domain.shows.model.TvShowModel

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
package com.winterprojects.tvmazeapp.domain.episodes.dtos

import com.winterprojects.tvmazeapp.domain.episodes.models.RatingModel

data class RatingDto(
    val average: Double?
)

fun RatingDto.toModel(): RatingModel {
    return RatingModel(
        this.average
    )
}
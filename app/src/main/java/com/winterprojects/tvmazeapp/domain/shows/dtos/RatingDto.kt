package com.winterprojects.tvmazeapp.domain.shows.dtos

import com.winterprojects.tvmazeapp.domain.shows.models.RatingModel

data class RatingDto(
    val average: Float?
)

fun RatingDto.toModel() =
    RatingModel(
        this.average
    )
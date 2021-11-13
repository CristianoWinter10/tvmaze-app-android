package com.winterprojects.tvmazeapp.domain.shows.dtos

import com.winterprojects.tvmazeapp.domain.shows.models.RatingModel

data class RatingDto(
    val average: Double?
)

fun RatingDto.toModel() =
    RatingModel(
        this.average
    )
package com.winterprojects.tvmazeapp.domain.shows.dto

import com.winterprojects.tvmazeapp.domain.shows.model.RatingModel

data class RatingDto(
    val average: Double?
)

fun RatingDto.toModel() =
    RatingModel(
        this.average
    )
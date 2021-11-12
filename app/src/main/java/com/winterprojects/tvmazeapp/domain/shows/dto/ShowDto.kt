package com.winterprojects.tvmazeapp.domain.shows.dto

import com.winterprojects.tvmazeapp.domain.shows.model.ShowModel

data class ShowDto(
    val averageRuntime: Int,
    val ended: String,
    val genres: List<String>,
    val id: Int,
    val image: ImageDto,
    val language: String,
    val name: String,
    val officialSite: String,
    val premiered: String,
    val rating: RatingDto,
    val status: String,
    val summary: String,
    val weight: Int
)

fun ShowDto.toModel(): ShowModel {
    return ShowModel(
        this.averageRuntime,
        this.ended,
        this.genres,
        this.id,
        this.image.toModel(),
        this.language,
        this.name,
        this.officialSite,
        this.premiered,
        this.rating.toModel(),
        this.status,
        this.summary,
        this.weight
    )
}
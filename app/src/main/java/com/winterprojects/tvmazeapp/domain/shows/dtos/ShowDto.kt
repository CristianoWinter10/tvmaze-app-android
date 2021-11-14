package com.winterprojects.tvmazeapp.domain.shows.dtos

import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

data class ShowDto(
    val averageRuntime: Int?,
    val ended: String?,
    val genres: List<String>?,
    val id: Int,
    val image: ImageDto?,
    val language: String?,
    val name: String,
    val officialSite: String?,
    val premiered: String?,
    val schedule: ScheduleDto?,
    val rating: RatingDto?,
    val status: String?,
    val summary: String?,
    val weight: Int?,
    val _embedded: EmbeddedDto?
)

fun ShowDto.toModel(): ShowModel {
    return ShowModel(
        this.averageRuntime,
        this.ended,
        this.genres,
        this.id,
        this.image?.toModel(),
        this.language,
        this.name,
        this.officialSite,
        this.premiered,
        this.schedule?.toModel(),
        this.rating?.toModel(),
        this.status,
        this.summary,
        this.weight,
        this._embedded?.toModel()
    )
}
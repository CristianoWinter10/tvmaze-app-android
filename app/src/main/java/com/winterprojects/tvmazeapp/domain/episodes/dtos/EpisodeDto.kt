package com.winterprojects.tvmazeapp.domain.episodes.dtos

import com.winterprojects.tvmazeapp.domain.episodes.models.EpisodeModel

data class EpisodeDto(
    val _links: LinksDto?,
    val airdate: String?,
    val airstamp: String?,
    val airtime: String?,
    val id: Int,
    val image: ImageDto?,
    val name: String?,
    val number: Int?,
    val rating: RatingDto?,
    val runtime: Int?,
    val season: Int,
    val summary: String?,
    val type: String?,
    val url: String?
)

fun EpisodeDto.toModel(): EpisodeModel {
    return EpisodeModel(
        this._links?.toModel(),
        this.airdate,
        this.airstamp,
        this.airtime,
        this.id,
        this.image?.toModel(),
        this.name,
        this.number,
        this.rating?.toModel(),
        this.runtime,
        this.season,
        this.summary,
        this.type,
        this.url
    )
}
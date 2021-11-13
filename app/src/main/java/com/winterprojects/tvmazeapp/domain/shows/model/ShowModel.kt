package com.winterprojects.tvmazeapp.domain.shows.model

data class ShowModel(
    val averageRuntime: Int?,
    val ended: String?,
    val genres: List<String>?,
    val id: Int,
    val image: ImageModel?,
    val language: String?,
    val name: String,
    val officialSite: String?,
    val premiered: String?,
    val rating: RatingModel?,
    val status: String?,
    val summary: String?,
    val weight: Int?
)
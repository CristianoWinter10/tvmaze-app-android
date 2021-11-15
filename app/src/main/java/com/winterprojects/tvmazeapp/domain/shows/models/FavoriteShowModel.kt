package com.winterprojects.tvmazeapp.domain.shows.models

import com.winterprojects.tvmazeapp.domain.shows.entities.FavoriteShowEntity

data class FavoriteShowModel(
    val id: Int,
    val name: String,
    val summary: String?,
    val imageUrl: String?
)

fun FavoriteShowModel.toEntity(): FavoriteShowEntity {
    return FavoriteShowEntity(
        this.id,
        this.name,
        this.summary,
        this.imageUrl
    )
}

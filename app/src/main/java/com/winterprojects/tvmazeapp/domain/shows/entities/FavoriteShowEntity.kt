package com.winterprojects.tvmazeapp.domain.shows.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel

@Entity
data class FavoriteShowEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val summary: String?,
    val imageUrl: String?
)

fun FavoriteShowEntity.toModel(): FavoriteShowModel {
    return FavoriteShowModel(
        this.id,
        this.name,
        this.summary,
        this.imageUrl
    )
}
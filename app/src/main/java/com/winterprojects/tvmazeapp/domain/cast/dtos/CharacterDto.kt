package com.winterprojects.tvmazeapp.domain.cast.dtos

import com.winterprojects.tvmazeapp.domain.cast.models.CharacterModel

data class CharacterDto(
    val _links: LinksDto,
    val id: Int,
    val image: CastImageDto,
    val name: String,
    val url: String
)

fun CharacterDto.toModel(): CharacterModel {
    return CharacterModel(
        this._links.toModel(),
        this.id,
        this.image.toModel(),
        this.name,
        this.url
    )
}
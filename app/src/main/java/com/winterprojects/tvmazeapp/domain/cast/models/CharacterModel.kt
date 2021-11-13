package com.winterprojects.tvmazeapp.domain.cast.models

data class CharacterModel(
    val _links: LinksModel,
    val id: Int,
    val image: CastImageModel,
    val name: String,
    val url: String
)
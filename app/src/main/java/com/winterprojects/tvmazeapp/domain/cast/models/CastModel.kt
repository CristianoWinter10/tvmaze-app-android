package com.winterprojects.tvmazeapp.domain.cast.models

data class CastModel(
    val character: CharacterModel,
    val person: PersonModel,
    val self: Boolean,
    val voice: Boolean
)
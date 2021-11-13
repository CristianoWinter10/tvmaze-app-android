package com.winterprojects.tvmazeapp.domain.cast.dtos

import com.winterprojects.tvmazeapp.domain.cast.models.CastModel

data class CastDto(
    val character: CharacterDto,
    val person: PersonDto,
    val self: Boolean,
    val voice: Boolean
)

fun CastDto.toModel(): CastModel {
    return CastModel(
        this.character.toModel(),
        this.person.toModel(),
        this.self,
        this.voice
    )
}
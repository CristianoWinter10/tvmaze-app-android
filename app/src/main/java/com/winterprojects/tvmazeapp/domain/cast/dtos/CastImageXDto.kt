package com.winterprojects.tvmazeapp.domain.cast.dtos

import com.winterprojects.tvmazeapp.domain.cast.models.CastImageXModel

data class CastImageXDto(
    val medium: String,
    val original: String
)

fun CastImageXDto.toModel(): CastImageXModel {
    return CastImageXModel(
        this.medium,
        this.original
    )
}
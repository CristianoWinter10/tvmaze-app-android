package com.winterprojects.tvmazeapp.domain.cast.dtos

import com.winterprojects.tvmazeapp.domain.cast.models.CastImageModel

data class CastImageDto(
    val medium: String,
    val original: String
)

fun CastImageDto.toModel(): CastImageModel {
    return CastImageModel(
        this.medium,
        this.original
    )
}
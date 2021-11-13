package com.winterprojects.tvmazeapp.domain.episodes.dtos

import com.winterprojects.tvmazeapp.domain.episodes.models.ImageModel

data class ImageDto(
    val medium: String,
    val original: String
)

fun ImageDto.toModel(): ImageModel {
    return ImageModel(
        this.medium,
        this.original
    )
}
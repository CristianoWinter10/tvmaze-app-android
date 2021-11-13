package com.winterprojects.tvmazeapp.domain.shows.dtos

import com.winterprojects.tvmazeapp.domain.shows.models.ImageModel

data class ImageDto(
    val medium: String?,
    val original: String?
)

fun ImageDto.toModel(): ImageModel {
    return ImageModel(
        this.medium,
        this.original
    )
}
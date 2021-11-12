package com.winterprojects.tvmazeapp.domain.shows.dto

import com.winterprojects.tvmazeapp.domain.shows.model.ImageModel

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
package com.winterprojects.tvmazeapp.domain.cast.dtos

import com.winterprojects.tvmazeapp.domain.cast.models.LinksModel

data class LinksDto(
    val self: SelfDto
)

fun LinksDto.toModel(): LinksModel {
    return LinksModel(
        this.self.toModel()
    )
}
package com.winterprojects.tvmazeapp.domain.episodes.dtos

import com.winterprojects.tvmazeapp.domain.episodes.models.LinksModel

data class LinksDto(
    val self: SelfDto
)

fun LinksDto.toModel(): LinksModel {
    return LinksModel(
        this.self.toModel()
    )
}
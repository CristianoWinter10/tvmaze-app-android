package com.winterprojects.tvmazeapp.domain.cast.dtos

import com.winterprojects.tvmazeapp.domain.cast.models.LinksModel
import com.winterprojects.tvmazeapp.domain.cast.models.LinksXModel

data class LinksXDto(
    val self: SelfXDto
)

fun LinksXDto.toModel(): LinksXModel{
    return LinksXModel(
        this.self.toModel()
    )
}
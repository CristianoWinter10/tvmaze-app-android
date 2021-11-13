package com.winterprojects.tvmazeapp.domain.cast.dtos

import com.winterprojects.tvmazeapp.domain.cast.models.SelfXModel

data class SelfXDto(
    val href: String
)

fun SelfXDto.toModel(): SelfXModel {
    return SelfXModel(
        this.href
    )
}
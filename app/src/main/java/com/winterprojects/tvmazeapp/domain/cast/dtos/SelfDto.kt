package com.winterprojects.tvmazeapp.domain.cast.dtos

import com.winterprojects.tvmazeapp.domain.cast.models.SelfModel

data class SelfDto(
    val href: String
)

fun SelfDto.toModel(): SelfModel {
    return SelfModel(
        this.href
    )
}
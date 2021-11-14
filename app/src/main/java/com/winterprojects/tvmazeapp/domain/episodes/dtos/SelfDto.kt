package com.winterprojects.tvmazeapp.domain.episodes.dtos

import com.winterprojects.tvmazeapp.domain.episodes.models.SelfModel

data class SelfDto(
    val href: String?
)

fun SelfDto.toModel(): SelfModel {
    return SelfModel(
        this.href
    )
}
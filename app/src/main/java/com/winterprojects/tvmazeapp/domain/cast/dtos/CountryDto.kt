package com.winterprojects.tvmazeapp.domain.cast.dtos

import com.winterprojects.tvmazeapp.domain.cast.models.CountryModel

data class CountryDto(
    val code: String,
    val name: String,
    val timezone: String
)

fun CountryDto.toModel(): CountryModel {
    return CountryModel(
        this.code,
        this.name,
        this.timezone
    )
}
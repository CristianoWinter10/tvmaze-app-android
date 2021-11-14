package com.winterprojects.tvmazeapp.domain.cast.dtos

import com.winterprojects.tvmazeapp.domain.cast.models.PersonModel

data class PersonDto(
    val _links: LinksXDto,
    val birthday: String,
    val country: CountryDto,
    val deathday: String,
    val gender: String,
    val id: Int,
    val image: CastImageXDto,
    val name: String,
    val updated: Int,
    val url: String
)

fun PersonDto.toModel(): PersonModel {
    return PersonModel(
        this._links.toModel(),
        this.birthday,
        this.country.toModel(),
        this.deathday,
        this.gender,
        this.id,
        this.image.toModel(),
        this.name,
        this.updated,
        this.url
    )
}
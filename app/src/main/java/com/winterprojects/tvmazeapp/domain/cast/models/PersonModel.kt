package com.winterprojects.tvmazeapp.domain.cast.models

data class PersonModel(
    val _links: LinksXModel,
    val birthday: String,
    val country: CountryModel,
    val deathday: Any,
    val gender: String,
    val id: Int,
    val image: CastImageXModel,
    val name: String,
    val updated: Int,
    val url: String
)
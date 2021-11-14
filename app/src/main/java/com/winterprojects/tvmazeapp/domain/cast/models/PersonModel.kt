package com.winterprojects.tvmazeapp.domain.cast.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonModel(
    val _links: LinksXModel,
    val birthday: String,
    val country: CountryModel,
    val deathday: String,
    val gender: String,
    val id: Int,
    val image: CastImageXModel,
    val name: String,
    val updated: Int,
    val url: String
): Parcelable
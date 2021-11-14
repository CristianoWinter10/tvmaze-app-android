package com.winterprojects.tvmazeapp.domain.cast.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharacterModel(
    val _links: LinksModel,
    val id: Int,
    val image: CastImageModel,
    val name: String,
    val url: String
): Parcelable
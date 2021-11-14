package com.winterprojects.tvmazeapp.domain.cast.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CastModel(
    val character: CharacterModel,
    val person: PersonModel,
    val self: Boolean,
    val voice: Boolean
): Parcelable
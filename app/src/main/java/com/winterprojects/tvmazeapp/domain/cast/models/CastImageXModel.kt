package com.winterprojects.tvmazeapp.domain.cast.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CastImageXModel(
    val medium: String,
    val original: String
): Parcelable
package com.winterprojects.tvmazeapp.domain.shows.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageModel(
    val medium: String?,
    val original: String?
): Parcelable
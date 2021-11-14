package com.winterprojects.tvmazeapp.domain.shows.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RatingModel(
    val average: Float?
): Parcelable
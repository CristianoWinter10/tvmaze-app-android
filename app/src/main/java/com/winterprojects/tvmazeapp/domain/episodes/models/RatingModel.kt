package com.winterprojects.tvmazeapp.domain.episodes.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RatingModel(
    val average: Double?
): Parcelable
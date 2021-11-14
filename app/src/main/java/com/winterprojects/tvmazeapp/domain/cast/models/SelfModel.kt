package com.winterprojects.tvmazeapp.domain.cast.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SelfModel(
    val href: String
): Parcelable
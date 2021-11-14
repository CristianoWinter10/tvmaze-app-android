package com.winterprojects.tvmazeapp.domain.cast.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CountryModel(
    val code: String,
    val name: String,
    val timezone: String
): Parcelable
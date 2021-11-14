package com.winterprojects.tvmazeapp.domain.shows.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduleModel(
    val days: List<String>?,
    val time: String?
): Parcelable
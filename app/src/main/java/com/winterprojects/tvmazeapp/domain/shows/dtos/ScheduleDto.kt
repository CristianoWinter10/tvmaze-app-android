package com.winterprojects.tvmazeapp.domain.shows.dtos

import com.winterprojects.tvmazeapp.domain.shows.models.ScheduleModel

data class ScheduleDto(
    val days: List<String>,
    val time: String
)

fun ScheduleDto.toModel(): ScheduleModel{
    return ScheduleModel(
        this.days,
        this.time
    )
}
package com.winterprojects.tvmazeapp.presentation.showDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.ScheduleModel

class DayTimeSeriesAirsViewModel : ViewModel() {
    private var mutableSchedule = MutableLiveData<ResultState<ScheduleModel>>()

    val schedule: LiveData<ResultState<ScheduleModel>>
        get() = mutableSchedule

    fun updateSchedule(scheduleModel: ScheduleModel?) {
        scheduleModel?.let { schedule ->
            if (schedule.days?.isNullOrEmpty() == true) {
                mutableSchedule.postValue(ResultState.Empty)
            } else {
                mutableSchedule.postValue(ResultState.Loaded(schedule))
            }

        } ?: mutableSchedule.postValue(ResultState.Empty)

    }
}
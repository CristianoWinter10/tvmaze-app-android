package com.winterprojects.tvmazeapp.presentation.season

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterprojects.tvmazeapp.business.shows.FetchSeasonUseCase
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.season.SeasonModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SeasonViewModel(
    private val showId: Int,
    private val fetchSeasonUseCase: FetchSeasonUseCase,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private var mutableSeasons = MutableLiveData<ResultState<List<SeasonModel>>>()

    val seasons: LiveData<ResultState<List<SeasonModel>>>
        get() = mutableSeasons

    init {
        viewModelScope.launch {
            withContext(defaultDispatcher) {
                fetchSeasonUseCase(showId).let { result ->
                    mutableSeasons.postValue(result)
                }
            }
        }
    }
}
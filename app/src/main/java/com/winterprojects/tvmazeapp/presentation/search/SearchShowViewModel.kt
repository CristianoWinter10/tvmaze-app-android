package com.winterprojects.tvmazeapp.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterprojects.tvmazeapp.business.shows.FetchShowsUseCase
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.model.TvShowModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchShowViewModel(
    private val fetchShowsUseCase: FetchShowsUseCase,
    private val dispatcherRequest: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private var _resultStateShows = MutableLiveData<ResultState<List<TvShowModel>>>()

    val resultStateShows: LiveData<ResultState<List<TvShowModel>>>
        get() = _resultStateShows

    fun fetchShows(name: String) {
        _resultStateShows.postValue(ResultState.Loading)

        viewModelScope.launch {
            withContext(dispatcherRequest) {
                fetchShowsUseCase(name).let { result ->
                    _resultStateShows.postValue(result)
                }
            }
        }
    }
}
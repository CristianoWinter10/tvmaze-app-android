package com.winterprojects.tvmazeapp.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterprojects.tvmazeapp.business.search.FetchShowsUseCase
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchShowViewModel(
    private val fetchShowsUseCase: FetchShowsUseCase,
    private val dispatcherRequest: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    private var mutableResultStateShows = MutableLiveData<ResultState<List<TvShowModel>>>()

    val resultStateShows: LiveData<ResultState<List<TvShowModel>>>
        get() = mutableResultStateShows

    fun fetchShows(name: String) {
        mutableResultStateShows.postValue(ResultState.Loading)

        viewModelScope.launch {
            withContext(dispatcherRequest) {
                fetchShowsUseCase(name).let { result ->
                    mutableResultStateShows.postValue(result)
                }
            }
        }
    }
}
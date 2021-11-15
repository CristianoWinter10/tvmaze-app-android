package com.winterprojects.tvmazeapp.presentation.show

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterprojects.tvmazeapp.business.shows.CheckShowIsAlreadyFavoriteUseCase
import com.winterprojects.tvmazeapp.business.shows.FetchShowMainInformationUseCase
import com.winterprojects.tvmazeapp.business.shows.UpdateShowFavoriteStatusUseCase
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShowDetailsViewModel(
    showId: Int,
    private val fetchShowMainInformationUseCase: FetchShowMainInformationUseCase,
    private val checkShowIsAlreadyFavoriteUseCase: CheckShowIsAlreadyFavoriteUseCase,
    private val updateShowFavoriteStatusUseCase: UpdateShowFavoriteStatusUseCase
) : ViewModel() {

    private var mutableShow = MutableLiveData<ShowModel>()

    val show: LiveData<ShowModel>
        get() = mutableShow

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                fetchShowMainInformationUseCase(showId).let { resultState ->
                    when (resultState) {
                        is ResultState.Loaded -> {
                            val show = resultState.data
                            mutableShow.postValue(show)
                            keepCheckingShowIsFavorite(showId, show)
                        }
                    }
                }
            }
        }
    }

    private suspend fun keepCheckingShowIsFavorite(
        showId: Int,
        show: ShowModel
    ) {
        checkShowIsAlreadyFavoriteUseCase(showId).collectLatest { isFavorite ->
            show.isFavorite = isFavorite
            mutableShow.postValue(show)
        }
    }

    fun updateFavoriteStatus() {
        mutableShow.value?.let { show ->
            viewModelScope.launch {
                withContext(Dispatchers.IO) {

                    show.isFavorite = !show.isFavorite

                    updateShowFavoriteStatusUseCase(show).let { result ->
                        when (result) {
                            is ResultState.ErrorState -> {
                                show.isFavorite = !show.isFavorite
                            }
                            is ResultState.Loaded -> {
                                mutableShow.postValue(show)
                            }
                            else -> {
                                show.isFavorite = !show.isFavorite
                            }
                        }

                        mutableShow.postValue(show)

                    }
                }
            }
        }
    }

}
package com.winterprojects.tvmazeapp.presentation.show

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterprojects.tvmazeapp.business.shows.CheckShowIsAlreadyFavoriteUseCase
import com.winterprojects.tvmazeapp.business.shows.UpdateShowFavoriteStatusUseCase
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ShowDetailsViewModel(
    tvShowModel: TvShowModel,
    private val checkShowIsAlreadyFavoriteUseCase: CheckShowIsAlreadyFavoriteUseCase,
    private val updateShowFavoriteStatusUseCase: UpdateShowFavoriteStatusUseCase
) : ViewModel() {

    private var mutableTvShow = MutableLiveData<TvShowModel>()

    val tvShow: LiveData<TvShowModel>
        get() = mutableTvShow


    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                checkShowIsAlreadyFavoriteUseCase(tvShowModel.show.id).let { isFavorite ->
                    tvShowModel.show.isFavorite = isFavorite
                    mutableTvShow.postValue(tvShowModel)
                }
            }
        }
    }

    fun updateFavoriteStatus() {
        mutableTvShow.value?.let { tvShow ->
            viewModelScope.launch {
                withContext(Dispatchers.IO) {

                    tvShow.show.isFavorite = !tvShow.show.isFavorite

                    updateShowFavoriteStatusUseCase(tvShow.show).let { result ->
                        when (result) {
                            is ResultState.ErrorState -> {
                                tvShow.show.isFavorite = !tvShow.show.isFavorite
                            }
                            is ResultState.Loaded -> {
                                mutableTvShow.postValue(tvShow)
                            }
                            else -> {
                                tvShow.show.isFavorite = !tvShow.show.isFavorite
                            }
                        }

                        mutableTvShow.postValue(tvShow)

                    }
                }
            }
        }
    }

}
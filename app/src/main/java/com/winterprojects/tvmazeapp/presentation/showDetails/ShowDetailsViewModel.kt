package com.winterprojects.tvmazeapp.presentation.showDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel

class ShowDetailsViewModel(tvShowModel: TvShowModel) : ViewModel() {

    private var mutableTvShow = MutableLiveData<TvShowModel>()

    val tvShow: LiveData<TvShowModel>
        get() = mutableTvShow

    init {
        mutableTvShow.postValue(tvShowModel)
    }

}
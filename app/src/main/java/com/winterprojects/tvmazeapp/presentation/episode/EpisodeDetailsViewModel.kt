package com.winterprojects.tvmazeapp.presentation.episode

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.winterprojects.tvmazeapp.domain.episodes.models.EpisodeModel

class EpisodeDetailsViewModel(episodeModel: EpisodeModel) : ViewModel() {
    private var mutableEpisode = MutableLiveData<EpisodeModel>()

    val episode: LiveData<EpisodeModel>
        get() = mutableEpisode

    init {
        mutableEpisode.postValue(episodeModel)
    }
}
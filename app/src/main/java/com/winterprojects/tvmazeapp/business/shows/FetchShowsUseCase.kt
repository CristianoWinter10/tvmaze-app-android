package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel

interface FetchShowsUseCase {
    suspend operator fun invoke(name: String): ResultState<List<TvShowModel>>
}
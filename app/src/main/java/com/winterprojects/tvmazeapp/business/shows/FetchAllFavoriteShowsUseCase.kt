package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel

interface FetchAllFavoriteShowsUseCase {
    suspend operator fun invoke(): ResultState<MutableList<FavoriteShowModel>>
}
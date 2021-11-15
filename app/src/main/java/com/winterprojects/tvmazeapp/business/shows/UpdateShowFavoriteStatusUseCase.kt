package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

interface UpdateShowFavoriteStatusUseCase {
    suspend operator fun invoke(showModel: ShowModel): ResultState<Boolean>
}
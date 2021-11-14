package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.season.SeasonModel

interface FetchSeasonUseCase {
    suspend operator fun invoke(showId: Int): ResultState<List<SeasonModel>>
}
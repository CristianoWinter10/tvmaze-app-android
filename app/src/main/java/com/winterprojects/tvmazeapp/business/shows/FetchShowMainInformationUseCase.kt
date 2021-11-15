package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

interface FetchShowMainInformationUseCase {
    suspend operator fun invoke(showId: Int): ResultState<ShowModel>
}
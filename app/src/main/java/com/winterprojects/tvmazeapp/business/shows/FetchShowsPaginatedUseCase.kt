package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

interface FetchShowsPaginatedUseCase {
    suspend operator fun invoke(page: Int): ResultState<List<ShowModel>>
}
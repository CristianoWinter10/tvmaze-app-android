package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel
import java.lang.Exception

class FetchShowsPaginatedUseCaseImpl(private val showRepository: ShowRepository) :
    FetchShowsPaginatedUseCase {
    override suspend operator fun invoke(page: Int): ResultState<List<ShowModel>> {
        return try {
            ResultState.Loaded(showRepository.fetchShows(page))
        } catch (ex: Exception) {
            ResultState.ErrorState(ex.message)
        }
    }
}
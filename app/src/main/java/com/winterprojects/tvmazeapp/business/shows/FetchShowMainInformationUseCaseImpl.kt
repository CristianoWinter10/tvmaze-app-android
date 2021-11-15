package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

class FetchShowMainInformationUseCaseImpl(private val showRepository: ShowRepository) :
    FetchShowMainInformationUseCase {
    override suspend fun invoke(showId: Int): ResultState<ShowModel> {
        return try {
            ResultState.Loaded(showRepository.fetchShowMainInfoById(showId))
        } catch (ex: Exception) {
            ResultState.ErrorState(ex.message)
        }
    }

}
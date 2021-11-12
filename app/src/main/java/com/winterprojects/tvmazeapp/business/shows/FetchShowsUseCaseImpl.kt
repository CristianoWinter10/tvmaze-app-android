package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.helpers.ResultState.*
import com.winterprojects.tvmazeapp.domain.shows.model.TvShowModel
import java.lang.Exception

class FetchShowsUseCaseImpl(private val showRepository: ShowRepository): FetchShowsUseCase {
    override suspend fun invoke(name: String): ResultState<List<TvShowModel>> {
        return try {
            val shows = showRepository.fetchShowsByName(name)

            if(shows.isNotEmpty()){
                Loaded(shows)
            } else {
                Empty
            }
        } catch (ex: Exception) {
            ErrorState(ex.localizedMessage)
        }
    }
}
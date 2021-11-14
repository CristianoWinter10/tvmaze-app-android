package com.winterprojects.tvmazeapp.business.search

import com.winterprojects.tvmazeapp.datasource.search.SearchRepository
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.helpers.ResultState.*
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel
import java.lang.Exception

class FetchShowsUseCaseImpl(private val searchRepository: SearchRepository): FetchShowsUseCase {
    override suspend fun invoke(name: String): ResultState<List<TvShowModel>> {
        return try {
            val shows = searchRepository.fetchShowsByName(name)

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
package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

class ShowRepositoryImpl(private val showRemoteDatasource: ShowRemoteDatasource): ShowRepository {
    override suspend fun fetchCastByShowId(showId: Int): ShowModel {
        return showRemoteDatasource.fetchCastByShowId(showId)
    }

    override suspend fun fetchEpisodesByShowId(showId: Int): ShowModel {
        return showRemoteDatasource.fetchEpisodesByShowId(showId)
    }

}
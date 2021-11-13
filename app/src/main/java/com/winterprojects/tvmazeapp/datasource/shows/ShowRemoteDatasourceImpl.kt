package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.dtos.toModel
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel

class ShowRemoteDatasourceImpl(private val showClientApi: ShowClientApi) : ShowRemoteDatasource {
    override suspend fun fetchCastByShowId(showId: Int): List<ShowModel> {
        return showClientApi.fetchCastByShowId(showId).map { show ->
            show.toModel()
        }
    }

    override suspend fun fetchEpisodesByShowId(showId: Int): List<ShowModel> {
        return showClientApi.fetchCastByShowId(showId).map { show ->
            show.toModel()
        }
    }
}
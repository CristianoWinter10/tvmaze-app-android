package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.dtos.toModel
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

class ShowRemoteDatasourceImpl(private val showClientApi: ShowClientApi) : ShowRemoteDatasource {
    override suspend fun fetchCastByShowId(showId: Int): ShowModel {
        return showClientApi.fetchCastByShowId(showId).toModel()
    }

    override suspend fun fetchEpisodesByShowId(showId: Int): ShowModel {
        return showClientApi.fetchEpisodesByShowId(showId).toModel()
    }
}
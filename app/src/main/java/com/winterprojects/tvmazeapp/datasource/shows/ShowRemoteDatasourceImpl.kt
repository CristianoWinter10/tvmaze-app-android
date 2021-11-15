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

    override suspend fun fetchShows(page: Int): List<ShowModel> {
        return showClientApi.fetchShows(page).map { it.toModel() }
    }

    override suspend fun fetchShowMainInfoById(showId: Int): ShowModel {
        return showClientApi.fetchShowMainInfoById(showId).toModel()
    }

}
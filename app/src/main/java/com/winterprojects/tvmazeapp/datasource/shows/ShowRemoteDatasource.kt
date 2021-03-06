package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

interface ShowRemoteDatasource {
    suspend fun fetchCastByShowId(showId: Int): ShowModel

    suspend fun fetchEpisodesByShowId(showId: Int): ShowModel

    suspend fun fetchShows(page: Int): List<ShowModel>

    suspend fun fetchShowMainInfoById(showId: Int): ShowModel

}
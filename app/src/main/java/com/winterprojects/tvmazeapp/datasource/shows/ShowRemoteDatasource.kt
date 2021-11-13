package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

interface ShowRemoteDatasource {
    suspend fun fetchCastByShowId(showId: Int): List<ShowModel>

    suspend fun fetchEpisodesByShowId(showId: Int): List<ShowModel>
}
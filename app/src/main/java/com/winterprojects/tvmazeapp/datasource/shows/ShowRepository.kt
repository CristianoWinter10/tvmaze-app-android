package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

interface ShowRepository {
    suspend fun fetchCastByShowId(showId: Int): ShowModel

    suspend fun fetchEpisodesByShowId(showId: Int): ShowModel
}
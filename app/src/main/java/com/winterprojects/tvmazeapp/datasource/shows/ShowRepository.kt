package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.model.TvShowModel

interface ShowRepository {
    suspend fun fetchShowsByName(name: String): List<TvShowModel>
}
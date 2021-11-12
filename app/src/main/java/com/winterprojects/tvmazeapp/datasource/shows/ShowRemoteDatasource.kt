package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.model.TvShowModel

interface ShowRemoteDatasource {
    suspend fun fetchShowsByName(name: String): List<TvShowModel>
}
package com.winterprojects.tvmazeapp.datasource.search

import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel

interface SearchRemoteDatasource {
    suspend fun fetchShowsByName(name: String): List<TvShowModel>
}
package com.winterprojects.tvmazeapp.datasource.search

import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel

class SearchRepositoryImpl(private val showRemoteDatasource: SearchRemoteDatasource):
    SearchRepository {
    override suspend fun fetchShowsByName(name: String): List<TvShowModel> {
        return showRemoteDatasource.fetchShowsByName(name)
    }
}
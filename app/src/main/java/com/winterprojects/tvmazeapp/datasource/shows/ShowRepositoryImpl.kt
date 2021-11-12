package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.model.TvShowModel

class ShowRepositoryImpl(private val showRemoteDatasource: ShowRemoteDatasource): ShowRepository {
    override suspend fun fetchShowsByName(name: String): List<TvShowModel> {
        return showRemoteDatasource.fetchShowsByName(name)
    }
}
package com.winterprojects.tvmazeapp.datasource.search

import com.winterprojects.tvmazeapp.domain.shows.dtos.toModel
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel

class SearchRemoteDatasourceImpl(private val searchClientApi: SearchClientApi) :
    SearchRemoteDatasource {
    override suspend fun fetchShowsByName(name: String): List<TvShowModel> {
        return searchClientApi.fetchShowsByName(name).map { tvShowDto ->
            tvShowDto.toModel()
        }
    }
}
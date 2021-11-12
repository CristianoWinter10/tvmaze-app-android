package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.dto.toModel
import com.winterprojects.tvmazeapp.domain.shows.model.TvShowModel

class ShowRemoteDatasourceImpl(private val showClientApi: ShowClientApi) : ShowRemoteDatasource {
    override suspend fun fetchShowsByName(name: String): List<TvShowModel> {
        return showClientApi.fetchShowsByName(name).map { tvShowDto ->
            tvShowDto.toModel()
        }
    }
}
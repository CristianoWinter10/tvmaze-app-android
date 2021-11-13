@file:JvmName("ShowClientApiKt")

package com.winterprojects.tvmazeapp.datasource.search

import com.winterprojects.tvmazeapp.domain.shows.dtos.TvShowDto
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "search"

interface SearchClientApi {

    @GET("$BASE_URL/shows")
    suspend fun fetchShowsByName(@Query("q") name: String): List<TvShowDto>

}
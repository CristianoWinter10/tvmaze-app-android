package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.BuildConfig
import com.winterprojects.tvmazeapp.domain.shows.dto.ShowDto
import com.winterprojects.tvmazeapp.domain.shows.dto.TvShowDto
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "search"

interface ShowClientApi {

    @GET("$BASE_URL/shows")
    suspend fun fetchShowByName(@Query("q") name: String): List<TvShowDto>

}
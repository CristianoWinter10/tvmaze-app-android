package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.dtos.ShowDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "shows"

interface ShowClientApi {

    @GET("$BASE_URL/{showId}?embed=cast")
    suspend fun fetchCastByShowId(@Path("showId") showId: Int): ShowDto

    @GET("$BASE_URL/{showId}?embed=episodes")
    suspend fun fetchEpisodesByShowId(@Path("showId") showId: Int): ShowDto

    @GET(BASE_URL)
    suspend fun fetchShows(@Query("page") page: Int): List<ShowDto>

    @GET("$BASE_URL/{showId}")
    suspend fun fetchShowMainInfoById(@Path("showId") showId: Int): ShowDto
}
package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

interface ShowRepository {
    suspend fun fetchAllFavorites(): List<FavoriteShowModel>

    suspend fun fetchCastByShowId(showId: Int): ShowModel

    suspend fun fetchEpisodesByShowId(showId: Int): ShowModel

    suspend fun checkShowIsAlreadyFavorite(showId: Int): Boolean

    suspend fun upInsertShowFavorite(favoriteShowModel: FavoriteShowModel): Boolean

    suspend fun deleteShowFavorite(favoriteShowModel: FavoriteShowModel)
}
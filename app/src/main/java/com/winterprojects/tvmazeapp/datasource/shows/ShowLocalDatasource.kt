package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel

interface ShowLocalDatasource {
    suspend fun fetchAll(): List<FavoriteShowModel>

    suspend fun upInsert(favoriteShowModel: FavoriteShowModel): Boolean

    suspend fun delete(favoriteShowModel: FavoriteShowModel)

    suspend fun checkShowIsAlreadyFavorite(showId: Int): Boolean

}
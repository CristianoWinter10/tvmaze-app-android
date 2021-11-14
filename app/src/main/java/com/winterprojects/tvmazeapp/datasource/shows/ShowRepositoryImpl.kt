package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel

class ShowRepositoryImpl(private val showRemoteDatasource: ShowRemoteDatasource,
                         private val showLocalDatasource: ShowLocalDatasource): ShowRepository {
    override suspend fun fetchAllFavorites(): List<FavoriteShowModel> {
        return showLocalDatasource.fetchAll()
    }

    override suspend fun fetchCastByShowId(showId: Int): ShowModel {
        return showRemoteDatasource.fetchCastByShowId(showId)
    }

    override suspend fun fetchEpisodesByShowId(showId: Int): ShowModel {
        return showRemoteDatasource.fetchEpisodesByShowId(showId)
    }

    override suspend fun checkShowIsAlreadyFavorite(showId: Int): Boolean {
        return showLocalDatasource.checkShowIsAlreadyFavorite(showId)
    }

    override suspend fun upInsertShowFavorite(favoriteShowModel: FavoriteShowModel): Boolean {
        return showLocalDatasource.upInsert(favoriteShowModel)
    }

    override suspend fun deleteShowFavorite(favoriteShowModel: FavoriteShowModel) {
        showLocalDatasource.delete(favoriteShowModel)
    }

}
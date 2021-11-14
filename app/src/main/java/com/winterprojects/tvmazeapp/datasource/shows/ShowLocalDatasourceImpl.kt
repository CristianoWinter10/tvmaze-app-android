package com.winterprojects.tvmazeapp.datasource.shows

import com.winterprojects.tvmazeapp.domain.shows.entities.toModel
import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel
import com.winterprojects.tvmazeapp.domain.shows.models.toEntity

class ShowLocalDatasourceImpl(private val showDao: ShowDao) : ShowLocalDatasource {
    override suspend fun fetchAll(): List<FavoriteShowModel> {
        return showDao.fetchAll().map { it.toModel() }
    }

    override suspend fun upInsert(favoriteShowModel: FavoriteShowModel): Boolean {
        return showDao.upInsert(favoriteShowModel.toEntity()) > 0
    }

    override suspend fun delete(favoriteShowModel: FavoriteShowModel) {
        return showDao.delete(favoriteShowModel.toEntity())
    }

    override suspend fun checkShowIsAlreadyFavorite(showId: Int): Boolean {
        return showDao.checkIsFavorite(showId)
    }

}
package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel

class UpInsertFavoriteShowUseCaseImpl(private val repository: ShowRepository) :
    UpInsertFavoriteShowUseCase {
    override suspend operator fun invoke(favoriteShowModel: FavoriteShowModel): ResultState<Boolean> {
        return try {
            return ResultState.Loaded(repository.upInsertShowFavorite(favoriteShowModel))
        } catch (ex: Exception) {
            ResultState.ErrorState(ex.localizedMessage)
        }
    }
}
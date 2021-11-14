package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel

class DeleteFavoriteShowUseCaseImpl(private val repository: ShowRepository) :
    DeleteFavoriteShowUseCase {
    override suspend operator fun invoke(favoriteShowModel: FavoriteShowModel): ResultState<Boolean> {
        return try {
            repository.deleteShowFavorite(favoriteShowModel)
            return ResultState.Loaded(true)
        } catch (ex: Exception) {
            ResultState.ErrorState(ex.localizedMessage)
        }
    }
}
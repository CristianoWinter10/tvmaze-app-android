package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel
import com.winterprojects.tvmazeapp.domain.shows.models.toFavoriteShowModel

class UpdateShowFavoriteStatusUseCaseImpl(private val repository: ShowRepository) :
    UpdateShowFavoriteStatusUseCase {
    override suspend operator fun invoke(showModel: ShowModel): ResultState<Boolean> {
        return try {
            val favoriteShowModel = showModel.toFavoriteShowModel()

            if (showModel.isFavorite) {
                repository.upInsertShowFavorite(favoriteShowModel)

            } else {
                repository.deleteShowFavorite(favoriteShowModel)
            }


            ResultState.Loaded(true)
        } catch (ex: Exception) {
            ResultState.ErrorState(ex.localizedMessage)

        }
    }
}
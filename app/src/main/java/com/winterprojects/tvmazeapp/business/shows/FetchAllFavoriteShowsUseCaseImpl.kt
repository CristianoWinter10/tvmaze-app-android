package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel
import java.lang.Exception

class FetchAllFavoriteShowsUseCaseImpl(private val showRepository: ShowRepository) :
    FetchAllFavoriteShowsUseCase {
    override suspend operator fun invoke(): ResultState<MutableList<FavoriteShowModel>> {
        return try {
            val favorites = showRepository.fetchAllFavorites()

            if (favorites.isNotEmpty()) {
                ResultState.Loaded(favorites as MutableList<FavoriteShowModel>)
            } else {
                ResultState.Empty
            }
        } catch (ex: Exception) {
            ResultState.ErrorState(ex.localizedMessage)
        }
    }
}
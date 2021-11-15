package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CheckShowIsAlreadyFavoriteImpl(private val showRepository: ShowRepository) :
    CheckShowIsAlreadyFavoriteUseCase {
    override suspend operator fun invoke(showId: Int): Flow<Boolean> {
        return try {
             showRepository.checkShowIsAlreadyFavorite(showId)
        } catch (ex: Exception) {
            flowOf(false)
        }
    }
}
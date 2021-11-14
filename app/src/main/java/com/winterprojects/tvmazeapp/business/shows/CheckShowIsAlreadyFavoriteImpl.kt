package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository

class CheckShowIsAlreadyFavoriteImpl(private val showRepository: ShowRepository) :
    CheckShowIsAlreadyFavoriteUseCase {
    override suspend operator fun invoke(showId: Int): Boolean {
        return try {
            showRepository.checkShowIsAlreadyFavorite(showId)
        } catch (ex: Exception) {
            false
        }
    }
}
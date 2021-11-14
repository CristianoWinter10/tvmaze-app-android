package com.winterprojects.tvmazeapp.business.shows

interface CheckShowIsAlreadyFavoriteUseCase {
    suspend operator fun invoke(showId: Int): Boolean
}
package com.winterprojects.tvmazeapp.business.shows

import kotlinx.coroutines.flow.Flow

interface CheckShowIsAlreadyFavoriteUseCase {
    suspend operator fun invoke(showId: Int): Flow<Boolean>
}
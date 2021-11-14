package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel

interface UpInsertFavoriteShowUseCase {
    suspend operator fun invoke(favoriteShowModel: FavoriteShowModel): ResultState<Boolean>
}
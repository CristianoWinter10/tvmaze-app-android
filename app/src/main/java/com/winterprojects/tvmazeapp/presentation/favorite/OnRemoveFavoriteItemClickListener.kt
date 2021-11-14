package com.winterprojects.tvmazeapp.presentation.favorite

import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel

interface OnRemoveFavoriteItemClickListener {
    fun onRemoveFavoriteItemClickListener(itemPosition: Int, favoriteShowModel: FavoriteShowModel)
}
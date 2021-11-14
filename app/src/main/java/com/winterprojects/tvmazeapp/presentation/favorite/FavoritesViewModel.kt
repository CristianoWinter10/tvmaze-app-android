package com.winterprojects.tvmazeapp.presentation.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.winterprojects.tvmazeapp.business.shows.*
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.FavoriteShowModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesViewModel(
    private val fetchAllFavoriteShowsUseCase: FetchAllFavoriteShowsUseCase,
    private val upInsertFavoriteShowUseCase: UpInsertFavoriteShowUseCase,
    private val deleteFavoriteShowUseCase: DeleteFavoriteShowUseCase,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private var _lastPositionFavoriteShowModelRemoved: Int = 0

    val lastPositionFavoriteShowModelRemoved: Int
        get() = _lastPositionFavoriteShowModelRemoved

    private lateinit var _lastFavoriteShowModelRemoved: FavoriteShowModel

    private var mutableFavorites = MutableLiveData<ResultState<MutableList<FavoriteShowModel>>>()

    val favorites: LiveData<ResultState<MutableList<FavoriteShowModel>>>
        get() = mutableFavorites

    init {
        viewModelScope.launch {
            withContext(defaultDispatcher) {
                fetchAllFavoriteShowsUseCase().let { favorites ->
                    mutableFavorites.postValue(favorites)
                }
            }
        }
    }

    fun removeFavoriteItem(position: Int, favoriteShowModel: FavoriteShowModel) {
        _lastPositionFavoriteShowModelRemoved = position

        favorites.value?.data?.let {
            _lastFavoriteShowModelRemoved = it.first { x -> x.id == favoriteShowModel.id }

            it.remove(_lastFavoriteShowModelRemoved)

            removeFavoriteItemOnDb()

            if (it.isEmpty()) {
                mutableFavorites.postValue(ResultState.Empty)
            } else {
                mutableFavorites.postValue(ResultState.Loaded(it))
            }
        }

    }

    private fun removeFavoriteItemOnDb() {
        viewModelScope.launch {
            withContext(defaultDispatcher) {
                deleteFavoriteShowUseCase(_lastFavoriteShowModelRemoved)
            }
        }
    }


    fun undoRemoveFavoriteItem() {
        if (!this::_lastFavoriteShowModelRemoved.isInitialized) return

        favorites.value?.data?.let {
            it.add(_lastPositionFavoriteShowModelRemoved, _lastFavoriteShowModelRemoved)

            undoRemoveFavoriteShowOnDB()

            mutableFavorites.postValue(ResultState.Loaded(it))
        } ?: run {
            undoRemoveFavoriteShowOnDB()

            mutableFavorites.postValue(
                ResultState.Loaded(
                    mutableListOf(
                        _lastFavoriteShowModelRemoved
                    )
                )
            )
        }
    }

    private fun undoRemoveFavoriteShowOnDB() {
        viewModelScope.launch {
            withContext(defaultDispatcher) {
                upInsertFavoriteShowUseCase(_lastFavoriteShowModelRemoved)
            }
        }
    }
}
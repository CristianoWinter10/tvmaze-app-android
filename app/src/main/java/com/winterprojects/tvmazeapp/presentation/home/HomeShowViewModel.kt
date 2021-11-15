package com.winterprojects.tvmazeapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.winterprojects.tvmazeapp.business.shows.FetchShowsPaginatedUseCase

class HomeShowViewModel(
    private val fetchShowsPaginatedUseCase: FetchShowsPaginatedUseCase
) : ViewModel() {
    val flowShows = Pager(
        PagingConfig(PAGE_SIZE_DEFAULT)
    ) {
        HomeShowPagingAdapter(fetchShowsPaginatedUseCase)
    }.flow.cachedIn(viewModelScope)

    companion object {
        private const val PAGE_SIZE_DEFAULT = 250
    }
}


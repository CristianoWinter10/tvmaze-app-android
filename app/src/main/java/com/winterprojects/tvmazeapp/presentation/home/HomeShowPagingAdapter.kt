package com.winterprojects.tvmazeapp.presentation.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.winterprojects.tvmazeapp.business.shows.FetchShowsPaginatedUseCase
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel
import retrofit2.HttpException
import java.io.IOException


class HomeShowPagingAdapter(private val fetchShowsPaginatedUseCase: FetchShowsPaginatedUseCase) :
    PagingSource<Int, ShowModel>() {
    override fun getRefreshKey(state: PagingState<Int, ShowModel>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(PAGE_NUM_PLUS)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(PAGE_NUM_PLUS)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ShowModel> {
        return try {
            val pageNumber = params.key ?: 0

            val response = fetchShowsPaginatedUseCase(pageNumber)

            val prevKey = if (pageNumber > 0) pageNumber - PAGE_NUM_PLUS else null

            val nextKey = if (response.data.isNullOrEmpty()) {
                null
            } else {
                pageNumber + PAGE_NUM_PLUS
            }

            LoadResult.Page(
                data = response.data ?: listOf(),
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val PAGE_NUM_PLUS = 1
    }
}
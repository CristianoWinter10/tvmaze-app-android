package com.winterprojects.tvmazeapp.business.di

import com.winterprojects.tvmazeapp.business.search.FetchShowsUseCase
import com.winterprojects.tvmazeapp.business.search.FetchShowsUseCaseImpl
import com.winterprojects.tvmazeapp.business.shows.*
import org.koin.dsl.module

object BusinessDI {
    val module = module {
        single<FetchShowsUseCase> {
            FetchShowsUseCaseImpl(get())
        }

        single<FetchSeasonUseCase> {
            FetchSeasonUseCaseImpl(get())
        }

        single<CheckShowIsAlreadyFavoriteUseCase> {
            CheckShowIsAlreadyFavoriteImpl(get())
        }

        single<UpdateShowFavoriteStatusUseCase> {
            UpdateShowFavoriteStatusUseCaseImpl(get())
        }

        single<UpInsertFavoriteShowUseCase> {
            UpInsertFavoriteShowUseCaseImpl(get())
        }

        single<DeleteFavoriteShowUseCase> {
            DeleteFavoriteShowUseCaseImpl(get())
        }

        single<FetchAllFavoriteShowsUseCase> {
            FetchAllFavoriteShowsUseCaseImpl(get())
        }

        single<FetchShowsPaginatedUseCase> {
            FetchShowsPaginatedUseCaseImpl(get())
        }

        single<FetchShowMainInformationUseCase> {
            FetchShowMainInformationUseCaseImpl(get())
        }
    }
}
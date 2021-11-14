package com.winterprojects.tvmazeapp.business.di

import com.winterprojects.tvmazeapp.business.search.FetchShowsUseCase
import com.winterprojects.tvmazeapp.business.search.FetchShowsUseCaseImpl
import com.winterprojects.tvmazeapp.business.shows.FetchSeasonUseCase
import com.winterprojects.tvmazeapp.business.shows.FetchSeasonUseCaseImpl
import org.koin.dsl.module

object BusinessDI {
    val module = module {
        single<FetchShowsUseCase> {
            FetchShowsUseCaseImpl(get())
        }

        single<FetchSeasonUseCase> {
            FetchSeasonUseCaseImpl(get())
        }
    }
}
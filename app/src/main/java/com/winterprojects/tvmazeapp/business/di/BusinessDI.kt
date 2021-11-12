package com.winterprojects.tvmazeapp.business.di

import com.winterprojects.tvmazeapp.business.shows.FetchShowsUseCase
import com.winterprojects.tvmazeapp.business.shows.FetchShowsUseCaseImpl
import org.koin.dsl.module

object BusinessDI {
    val module = module {
        single<FetchShowsUseCase> {
            FetchShowsUseCaseImpl(get())
        }
    }
}
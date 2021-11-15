package com.winterprojects.tvmazeapp.datasource.di

import com.winterprojects.tvmazeapp.datasource.search.SearchRemoteDatasource
import com.winterprojects.tvmazeapp.datasource.search.SearchRemoteDatasourceImpl
import com.winterprojects.tvmazeapp.datasource.search.SearchRepository
import com.winterprojects.tvmazeapp.datasource.search.SearchRepositoryImpl
import com.winterprojects.tvmazeapp.datasource.shows.*
import org.koin.dsl.module

object DatasourceDI {
    val module = module {

        //Search
        single<SearchRemoteDatasource> {
            SearchRemoteDatasourceImpl(get())
        }

        single<SearchRepository> {
            SearchRepositoryImpl(get())
        }

        //Show
        single<ShowRemoteDatasource> {
            ShowRemoteDatasourceImpl(get())
        }

        single<ShowLocalDatasource> {
            ShowLocalDatasourceImpl(get())
        }

        single<ShowRepository> {
            ShowRepositoryImpl(get(), get())
        }

    }
}
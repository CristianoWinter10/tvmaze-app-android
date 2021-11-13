package com.winterprojects.tvmazeapp.datasource.di

import com.winterprojects.tvmazeapp.datasource.search.SearchRemoteDatasource
import com.winterprojects.tvmazeapp.datasource.search.SearchRemoteDatasourceImpl
import com.winterprojects.tvmazeapp.datasource.search.SearchRepository
import com.winterprojects.tvmazeapp.datasource.search.SearchRepositoryImpl
import org.koin.dsl.module

object DatasourceDI {
    val module = module {

        //Show
        single<SearchRemoteDatasource> {
            SearchRemoteDatasourceImpl(get())
        }

        single<SearchRepository> {
            SearchRepositoryImpl(get())
        }

    }
}
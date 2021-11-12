package com.winterprojects.tvmazeapp.datasource.di

import com.winterprojects.tvmazeapp.datasource.shows.ShowRemoteDatasource
import com.winterprojects.tvmazeapp.datasource.shows.ShowRemoteDatasourceImpl
import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import com.winterprojects.tvmazeapp.datasource.shows.ShowRepositoryImpl
import org.koin.dsl.module

object DatasourceDI {
    val module = module {

        //Show
        single<ShowRemoteDatasource> {
            ShowRemoteDatasourceImpl(get())
        }

        single<ShowRepository> {
            ShowRepositoryImpl(get())
        }

    }
}
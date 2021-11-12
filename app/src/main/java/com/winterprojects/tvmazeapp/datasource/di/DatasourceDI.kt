package com.winterprojects.tvmazeapp.datasource.di

import com.winterprojects.tvmazeapp.datasource.shows.ShowRemoteDatasource
import com.winterprojects.tvmazeapp.datasource.shows.ShowRemoteDatasourceImpl
import org.koin.dsl.module

object DatasourceDI {
    val module = module {

        single<ShowRemoteDatasource> {
            //Show
            ShowRemoteDatasourceImpl(get())
        }

    }
}
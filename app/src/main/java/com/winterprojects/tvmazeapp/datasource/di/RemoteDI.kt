package com.winterprojects.tvmazeapp.datasource.di

import com.winterprojects.tvmazeapp.datasource.shows.ShowClientApi
import org.koin.dsl.module
import retrofit2.Retrofit

object RemoteDI {
    val module = module {

        factory<ShowClientApi> {
            get<Retrofit>().create(ShowClientApi::class.java)
        }

    }
}
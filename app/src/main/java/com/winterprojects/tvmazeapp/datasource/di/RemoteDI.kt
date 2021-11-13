package com.winterprojects.tvmazeapp.datasource.di

import com.winterprojects.tvmazeapp.datasource.search.SearchClientApi
import org.koin.dsl.module
import retrofit2.Retrofit

object RemoteDI {
    val module = module {

        factory<SearchClientApi> {
            get<Retrofit>().create(SearchClientApi::class.java)
        }

    }
}
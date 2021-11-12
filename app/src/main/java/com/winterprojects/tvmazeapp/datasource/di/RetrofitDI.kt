package com.winterprojects.tvmazeapp.datasource.di

import com.winterprojects.tvmazeapp.BuildConfig
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit.Builder

object RetrofitDI {
    val module = module {
        single<Builder> {
            Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())

        }

        single<Retrofit> {
            get<Builder>().build()
        }
    }
}
package com.winterprojects.tvmazeapp.datasource.di

import androidx.room.Room
import com.winterprojects.tvmazeapp.datasource.database.TVmazeDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DatabaseDI {
    val module = module {
        single {
            Room.databaseBuilder(
                androidContext(),
                TVmazeDatabase::class.java,
                TVmazeDatabase.DATABASE_NAME
            ).build()
        }

        single {
            get<TVmazeDatabase>().showDao()
        }
    }
}
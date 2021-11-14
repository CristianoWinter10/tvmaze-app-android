package com.winterprojects.tvmazeapp.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.winterprojects.tvmazeapp.datasource.database.TVmazeDatabase.Companion.VERSION
import com.winterprojects.tvmazeapp.datasource.shows.ShowDao
import com.winterprojects.tvmazeapp.domain.shows.entities.FavoriteShowEntity

@Database(version = VERSION, entities = [
    FavoriteShowEntity::class
])
abstract class TVmazeDatabase: RoomDatabase() {

    abstract fun showDao(): ShowDao

    companion object {
        const val VERSION = 1
        const val DATABASE_NAME = "tvmaze_database.db"
    }
}
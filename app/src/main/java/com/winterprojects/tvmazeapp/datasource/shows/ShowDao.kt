package com.winterprojects.tvmazeapp.datasource.shows

import androidx.room.*
import com.winterprojects.tvmazeapp.domain.shows.entities.FavoriteShowEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShowDao {

    @Query("SELECT * FROM FavoriteShowEntity")
    suspend fun fetchAll(): List<FavoriteShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upInsert(favoriteShowEntity: FavoriteShowEntity): Long

    @Delete
    suspend fun delete(favoriteShowEntity: FavoriteShowEntity)

    @Query(
        """
            SELECT 
              case when count(*) > 0 THEN 1
              else 0 END AS isFavorite 
            FROM 
                FavoriteShowEntity
            WHERE
                id = :showId
        """
    )
    fun checkIsFavorite(showId: Int): Flow<Boolean>
}
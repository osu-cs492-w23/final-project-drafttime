package com.example.drafttime.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(player: PlayerInfo)

    @Delete
    suspend fun delete(player: PlayerInfo)

    @Query("SELECT * FROM PlayerInfo")
    fun getAllPlayers(): Flow<List<PlayerInfo>>

}
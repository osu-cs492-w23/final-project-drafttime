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

    @Query("SELECT * FROM PlayerInfo WHERE postion = 'QB';")
    fun getAllQb(): Flow<List<PlayerInfo>>

    @Query("SELECT * FROM PlayerInfo WHERE postion = 'RB';")
    fun getAllRb(): Flow<List<PlayerInfo>>

    @Query("SELECT * FROM PlayerInfo WHERE postion = 'WR';")
    fun getAllWr():Flow<List<PlayerInfo>>
    @Query("SELECT * FROM PlayerInfo WHERE postion = 'TE';")
    fun getAllTe():Flow<List<PlayerInfo>>

}
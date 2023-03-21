package com.example.drafttime.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(player: PlayerInfo)
    @Delete
    suspend fun delete(player: PlayerInfo)

}
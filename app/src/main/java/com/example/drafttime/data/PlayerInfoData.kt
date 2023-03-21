package com.example.drafttime.data

class PlayerInfoData(
    private val dao: PlayerDao
    ){

   suspend fun insertPlayer(player: PlayerInfo) = dao.insert(player)
    suspend fun deletePlayer(player: PlayerInfo) = dao.delete(player)


}

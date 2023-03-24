package com.example.drafttime.data

class PlayerInfoData(
    private val dao: PlayerDao
) {

    suspend fun insertPlayer(player: PlayerInfo) = dao.insert(player)
    suspend fun deletePlayer(player: PlayerInfo) = dao.delete(player)

    fun getAllPlayerData() = dao.getAllPlayers()
    fun getAllQbData() = dao.getAllQb()
    fun getAllRbData() = dao.getAllRb()
    fun getAllWrData() = dao.getAllWr()
    fun getAllTeData() = dao.getAllTe()

}

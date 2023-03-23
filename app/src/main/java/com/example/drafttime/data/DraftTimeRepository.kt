package com.example.drafttime.data

import com.example.drafttime.api.ConnectedSleeper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DraftTimeRepository(
    private val service: ConnectedSleeper,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun loadPlayers(): Result<List<List<PlayerInfo>>> =
        withContext(dispatcher) {
            try {
                val response = service.getPlayerData()

                if (response.isSuccessful) {
                    Result.success(response.body()!!)

                } else {
                    Result.failure(Exception(response.errorBody()!!.string()))

                }

            } catch (e: Exception) {
                Result.failure(e)

            }


        }
}
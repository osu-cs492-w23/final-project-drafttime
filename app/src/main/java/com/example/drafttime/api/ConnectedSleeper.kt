package com.example.drafttime.api

import com.example.drafttime.data.PlayerInfo
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


// This file is our interface with the Sleeper api to get player data
interface ConnectedSleeper {

    @GET("nflTeamDataArray")
    suspend fun getPlayerData(
    ): Response<List<List<PlayerInfo>>>

    companion object {

        private const val BASE_URL = "http://10.0.2.2:8080/"
        fun create(): ConnectedSleeper {

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(ConnectedSleeper::class.java)

        }
    }
}
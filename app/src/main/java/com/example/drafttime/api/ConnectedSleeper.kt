package com.example.drafttime.api

import com.example.drafttime.data.PlayerData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


// This file is our interface with the Sleeper api to get player data
interface ConnectedSleeper {

    @GET("players/nfl")
    fun getPlayerData(
    ):Call<PlayerData>
    companion object{

        private const val BASE_URL =  "https://api.sleeper.app/v1/"
        fun create(): ConnectedSleeper {

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(ConnectedSleeper::class.java)

        }


    }
}
package com.example.drafttime_final

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ConnectedSleeper {
    @GET("players/nfl")
    fun getPlayerData(
    ): Call<PlayerData>
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
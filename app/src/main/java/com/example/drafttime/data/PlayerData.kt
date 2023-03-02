package com.example.drafttime.data

import com.squareup.moshi.Json

//this data class will have all data needed for the application and parsing the json data given to us from the Sleeper API

data class PlayerData(

    @Json(name = "full_name") val playerName: String

):java.io.Serializable

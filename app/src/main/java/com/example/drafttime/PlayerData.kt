package com.example.drafttime

import com.squareup.moshi.Json

data class PlayerData(

    @Json(name = "full_name") val playerName: String

):java.io.Serializable

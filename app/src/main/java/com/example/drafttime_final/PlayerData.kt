package com.example.drafttime_final

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class PlayerData(
    @Json(name = "full_name") val playerName: String



):java.io.Serializable

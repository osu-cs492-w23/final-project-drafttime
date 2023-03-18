package com.example.drafttime.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class PlayerData(

  val team: List<Player>



):java.io.Serializable
@JsonClass(generateAdapter = true)

data class Player(
  val player: PlayerInfo

):java.io.Serializable

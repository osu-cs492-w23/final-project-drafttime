package com.example.drafttime.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//this data class will have all data needed for the application and parsing the json data given to us from the Sleeper API

@JsonClass(generateAdapter = true)
data class PlayerData(

    @Json(name = "1") val player1: PlayerInfo,
    @Json(name = "2") val player2: PlayerInfo,
    @Json(name = "3") val player3: PlayerInfo,
    @Json(name = "4") val player4: PlayerInfo,
    @Json(name = "5") val player5: PlayerInfo,
    @Json(name = "6") val player6: PlayerInfo,
    @Json(name = "7") val player7: PlayerInfo,
    @Json(name = "8") val player8: PlayerInfo,
    @Json(name = "9") val player9: PlayerInfo,
    @Json(name = "10") val player10: PlayerInfo,
    @Json(name = "11") val player11: PlayerInfo,
    @Json(name = "12") val player12: PlayerInfo,
    @Json(name = "13") val player13: PlayerInfo,
    @Json(name = "14") val player14: PlayerInfo,
    @Json(name = "15") val player15: PlayerInfo,
    @Json(name = "16") val player16: PlayerInfo,
    @Json(name = "17") val player17: PlayerInfo,
    @Json(name = "18") val player18: PlayerInfo,
    @Json(name = "19") val player19: PlayerInfo,
    @Json(name = "20") val player20: PlayerInfo,
    @Json(name = "21") val player21: PlayerInfo,
    @Json(name = "22") val player22: PlayerInfo,
    @Json(name = "23") val player23: PlayerInfo,
    @Json(name = "24") val player24: PlayerInfo,
    @Json(name = "25") val player25: PlayerInfo,
    @Json(name = "26") val player26: PlayerInfo,
    @Json(name = "27") val player27: PlayerInfo,
    @Json(name = "28") val player28: PlayerInfo,
    @Json(name = "29") val player29: PlayerInfo,
    @Json(name = "30") val player30: PlayerInfo,
    @Json(name = "31") val player31: PlayerInfo,
    @Json(name = "32") val player32: PlayerInfo,
    @Json(name = "33") val player33: PlayerInfo,
    @Json(name = "34") val player34: PlayerInfo,
    @Json(name = "35") val player35: PlayerInfo,
    @Json(name = "36") val player36: PlayerInfo,
    @Json(name = "37") val player37: PlayerInfo,
    @Json(name = "38") val player38: PlayerInfo,
    @Json(name = "39") val player39: PlayerInfo,
    @Json(name = "40") val player40: PlayerInfo,
    @Json(name = "41") val player41: PlayerInfo,
    @Json(name = "42") val player42: PlayerInfo,
    @Json(name = "43") val player43: PlayerInfo,
    @Json(name = "44") val player44: PlayerInfo,
    @Json(name = "45") val player45: PlayerInfo,
    @Json(name = "46") val player46: PlayerInfo,
    @Json(name = "47") val player47: PlayerInfo,
    @Json(name = "48") val player48: PlayerInfo,
    @Json(name = "49") val player49: PlayerInfo,
    @Json(name = "50") val player50: PlayerInfo,

    ):java.io.Serializable


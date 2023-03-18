package com.example.drafttime.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)

data class PlayerInfo(
    @Json(name = "birth_date") val birthDate: String?,
@Json(name = "full_name") val fullName: String?,
@Json(name = "college") val college: String?,
@Json(name = "team") val team : String?,
@Json(name = "position") val postion: String?,
@Json(name = "number") val number: Int?,
@Json(name = "age") val age: String?,
@Json(name = "weight") val weight: String?,
@Json(name = "height") val height: String?
):java.io.Serializable


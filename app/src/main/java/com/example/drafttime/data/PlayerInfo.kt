package com.example.drafttime.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
@Entity
data class PlayerInfo(

    @Json(name = "birth_date") val birthDate: String?,
    @PrimaryKey
    @Json(name = "full_name") val fullName: String,
    @Json(name = "college") val college: String?,
    @Json(name = "team") val team: String?,
    @Json(name = "position") val postion: String?,
    @Json(name = "number") val number: Int?,
    @Json(name = "age") var age: String?,
    @Json(name = "weight") val weight: String?,
    @Json(name = "height") val height: String?

) : java.io.Serializable


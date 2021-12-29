package com.github.nothing2512.skeleton.data.entities

import com.google.gson.annotations.SerializedName

data class UserEntities(
    @field:SerializedName("id") val id: Int,
    @field:SerializedName("login") val name: String,
    @field:SerializedName("avatar_url") val image: String
)
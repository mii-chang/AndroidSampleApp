package com.miichang.androidsampleapp.api.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserJson(
  @field:Json(name = "id") val id: String,
  @field:Json(name = "name") val name: String
)

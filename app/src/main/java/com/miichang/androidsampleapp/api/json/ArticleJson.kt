package com.miichang.androidsampleapp.api.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleJson(
  @field:Json(name = "id") val id: String,
  @field:Json(name = "rendered_body") val renderedBody: String,
  @field:Json(name = "body") val body: String,
  @field:Json(name = "created_at") val createdAt: String,
  @field:Json(name = "title") val title: String,
  @field:Json(name = "url") val url: String,
  @field:Json(name = "user") val user: UserJson
)

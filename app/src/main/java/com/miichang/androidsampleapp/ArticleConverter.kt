package com.miichang.androidsampleapp

import com.miichang.androidsampleapp.api.json.ArticleJson
import java.net.URL

internal object ArticleConverter {
    fun convertToEntity(
      index: Int,
      json: ArticleJson
    ): Article =
        Article(
          id = json.id,
          renderedBody = json.renderedBody,
          body = json.body,
          createdAt = DateConverter.convertStringToDate(
            json.createdAt,
            DateConverter.DatePattern.RFC3339
          ),
          title = json.title,
          url = URL(json.url),
          userId = json.user.id,
          index = index
        )
}

package com.miichang.androidsampleapp.repository

import androidx.paging.DataSource
import com.miichang.androidsampleapp.Article

internal interface ArticleRepository {
    suspend fun getAllArticle(
      page: Int = 0,
      per: Int = 15
    ): List<Article>

    fun getTaskDataSource(): DataSource.Factory<Int, Article>
    suspend fun clearCache()
}

package com.miichang.androidsampleapp.repository

import androidx.paging.DataSource
import com.miichang.androidsampleapp.Article
import com.miichang.androidsampleapp.ArticleConverter
import com.miichang.androidsampleapp.api.QiitaApi
import com.miichang.androidsampleapp.db.ArticleDao
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

internal class ArticleRepositoryImpl(
    private val qiitaApi: QiitaApi,
    private val articleDao: ArticleDao,
    cache: Map<String, Article> = emptyMap()
) : ArticleRepository {

    private val cache = cache.toMutableMap()

    override suspend fun getAllArticle(page: Int, per: Int): List<Article> = withContext(IO) {
        val jsonList = qiitaApi.getArticleList(
            page = page + 1,
            per = per
        )
        val nextIndex = articleDao.getLastIndex() + 1
        jsonList.mapIndexed { index, json ->
            ArticleConverter.convertToEntity(
                nextIndex + index,
                json
            )
        }.also { articleList ->
            articleList.forEach { article ->
                cache[article.id] = article
            }
            articleDao.bulkUpsert(articleList)
        }
    }

    override fun getTaskDataSource(): DataSource.Factory<Int, Article> = articleDao.selectAll()

    override suspend fun clearCache() = withContext(IO) {
        articleDao.deleteAll()
        cache.clear()
    }
}

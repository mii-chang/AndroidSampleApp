package com.miichang.androidsampleapp.ui

import androidx.paging.PagedList
import com.miichang.androidsampleapp.Article
import com.miichang.androidsampleapp.repository.ArticleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

internal class ArticleBoundaryCallback(
  private val articleRepository: ArticleRepository
) : PagedList.BoundaryCallback<Article>() {

  private val boundaryCallbackScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
  private var currentPageIndex = 0

  override fun onZeroItemsLoaded() {
    super.onZeroItemsLoaded()

    boundaryCallbackScope.launch {
      runCatching {
        articleRepository.getAllArticle()
      }.onSuccess {
        currentPageIndex += 1
      }
    }
  }

  override fun onItemAtEndLoaded(itemAtEnd: Article) {
    super.onItemAtEndLoaded(itemAtEnd)

    boundaryCallbackScope.launch {
      runCatching {
        articleRepository.getAllArticle(currentPageIndex, 15)
      }.onSuccess {
        currentPageIndex += 1
      }
    }
  }

  fun clear() {
    currentPageIndex = 0
  }
}

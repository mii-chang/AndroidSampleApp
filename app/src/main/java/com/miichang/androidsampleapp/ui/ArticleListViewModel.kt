package com.miichang.androidsampleapp.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.miichang.androidsampleapp.Article
import com.miichang.androidsampleapp.repository.ArticleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.net.URL

internal class ArticleListViewModel @ViewModelInject constructor(
    private val articleRepository: ArticleRepository
) : ViewModel(), ArticleListAdapterListener {

    private val _clickedArticle = MutableLiveData<URL>()
    val clickedArticle: LiveData<URL>
        get() = _clickedArticle

    private val articleBoundaryCallback = ArticleBoundaryCallback(
        articleRepository
    )

    val articlePagedList = LivePagedListBuilder(
        articleRepository.getTaskDataSource(),
        PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(15)
            .build()
    ).setBoundaryCallback(
        articleBoundaryCallback
    ).build()

    private val _isRefreshing = MediatorLiveData<Boolean>()
    val isRefreshing: LiveData<Boolean>
        get() = _isRefreshing

    init {
        _isRefreshing.addSource(articlePagedList) {
            _isRefreshing.value = false
        }
    }

    fun onSwipeRefresh() {
        _isRefreshing.value = true
        refreshArticleList()
    }

    private fun refreshArticleList() {
        articleBoundaryCallback.clear()
        articlePagedList.value?.run {
            if (loadedCount == 0) {
                dataSource.invalidate()
                return
            }
        }

        viewModelScope.launch {
            runCatching {
                articleRepository.clearCache()
            }
        }
    }

    override fun onClickArticle(article: Article) {
        _clickedArticle.value = article.url
    }

    override fun onCleared() {
        super.onCleared()

        CoroutineScope(Dispatchers.Main + Job()).launch {
            articleRepository.clearCache()
        }
    }
}

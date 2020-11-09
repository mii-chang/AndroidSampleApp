package com.miichang.androidsampleapp.ui

import com.miichang.androidsampleapp.Article


internal interface ArticleListAdapterListener {
  fun onClickArticle(article: Article)
}

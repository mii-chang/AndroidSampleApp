package com.miichang.androidsampleapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miichang.androidsampleapp.Article
import com.miichang.androidsampleapp.databinding.ViewArticleItemBinding

internal class ArticleViewHolder(
  private val binding: ViewArticleItemBinding
) : RecyclerView.ViewHolder(binding.root) {

  companion object {
    fun create(
      inflater: LayoutInflater,
      container: ViewGroup,
      attachToRoot: Boolean
    ): ArticleViewHolder = ArticleViewHolder(
      ViewArticleItemBinding.inflate(
        inflater,
        container,
        attachToRoot
      )
    )
  }

  fun bind(
    article: Article?,
    listener: ArticleListAdapterListener
  ) {
    binding.article = article
    binding.listener = listener
    binding.executePendingBindings()
  }
}

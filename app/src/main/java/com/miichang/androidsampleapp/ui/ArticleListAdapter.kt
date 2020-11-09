package com.miichang.androidsampleapp.ui

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.miichang.androidsampleapp.Article

internal class ArticleListAdapter(
    context: Context,
    private val listener: ArticleListAdapterListener
) : PagedListAdapter<Article, ArticleViewHolder>(ITEM_CALLBACK) {

    companion object {
        private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(
                oldItem: Article,
                newItem: Article
            ): Boolean = oldItem.id == newItem.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: Article,
                newItem: Article
            ): Boolean = oldItem == newItem
        }
    }

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder = ArticleViewHolder.create(
        inflater,
        parent,
        false
    )

    override fun onBindViewHolder(
        holder: ArticleViewHolder,
        position: Int
    ) {
        holder.bind(
            getItem(position),
            listener
        )
    }
}
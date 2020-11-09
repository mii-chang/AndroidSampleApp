package com.miichang.androidsampleapp.ui

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.miichang.androidsampleapp.databinding.FragmentArticleListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleListFragment : Fragment() {

    companion object {
        fun newInstance() = ArticleListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentArticleListBinding.inflate(
            inflater,
            container,
            false
        )

        val viewModel: ArticleListViewModel by viewModels()

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        val adapter = ArticleListAdapter(
            requireContext(),
            viewModel
        )

        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        viewModel.articlePagedList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.clickedArticle.observe(viewLifecycleOwner) { url ->
            CustomTabsIntent.Builder().apply {
                setShowTitle(true)
            }.build().launchUrl(requireContext(), Uri.parse(url.toString()))
        }
        return binding.root
    }
}

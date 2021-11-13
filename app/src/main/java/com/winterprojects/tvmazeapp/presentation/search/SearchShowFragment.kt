package com.winterprojects.tvmazeapp.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.winterprojects.tvmazeapp.common.helpers.SearchableQueryTextListener
import com.winterprojects.tvmazeapp.common.helpers.hideSoftKeyboard
import com.winterprojects.tvmazeapp.databinding.FragmentSearchShowBinding
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchShowFragment : Fragment() {
    private val searchableQueryTextListener: SearchableQueryTextListener =
        SearchableQueryTextListener(onSubmit = { hideSoftKeyboard() }, callback = { term ->
            searchShowViewModel.fetchShows(term)
        })

    private lateinit var showAdapter: ShowAdapter
    private lateinit var binding: FragmentSearchShowBinding

    private val searchShowViewModel: SearchShowViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchShowBinding.inflate(layoutInflater)

        initializeAdapter()
        initializeObservers()
        initializeListeners()

        return binding.root
    }

    private fun initializeListeners() {
        binding.searchViewShowTitle.setOnQueryTextListener(searchableQueryTextListener)
    }

    private fun initializeAdapter() {
        showAdapter = ShowAdapter()
        binding.recyclerViewShows.apply {
            adapter = showAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initializeObservers() {
        searchShowViewModel.resultStateShows.observe(viewLifecycleOwner) { result ->
            when (result) {
                ResultState.Empty -> {
                    // it will be implement
                }
                is ResultState.ErrorState -> {
                    // it will be implement
                }
                is ResultState.Loaded -> {
                    showAdapter.submitList(result.data)
                }
                ResultState.Loading -> {
                    // it will be implement
                }
            }
        }
    }
}


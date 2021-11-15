package com.winterprojects.tvmazeapp.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.winterprojects.tvmazeapp.common.helpers.OnItemClickListener
import com.winterprojects.tvmazeapp.common.helpers.SearchableQueryTextListener
import com.winterprojects.tvmazeapp.common.helpers.hideSoftKeyboard
import com.winterprojects.tvmazeapp.databinding.FragmentSearchShowBinding
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchShowFragment : Fragment(), OnItemClickListener<TvShowModel> {
    private val searchableQueryTextListener: SearchableQueryTextListener =
        SearchableQueryTextListener(onSubmit = { hideSoftKeyboard() }, callback = { term ->
            searchShowViewModel.fetchShows(term)
        })

    private lateinit var searchShowAdapter: SearchShowAdapter
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
        searchShowAdapter = SearchShowAdapter(this)
        binding.recyclerViewShows.apply {
            adapter = searchShowAdapter
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
                    searchShowAdapter.submitList(result.data)
                }
                ResultState.Loading -> {
                    // it will be implement
                }
            }
        }
    }

    override fun onItemClick(tvShowModel: TvShowModel) {
        val action =
            SearchShowFragmentDirections.actionSearchShowFragmentToHomeNavGraph(tvShowModel.show.id)
        findNavController().navigate(action)
    }
}


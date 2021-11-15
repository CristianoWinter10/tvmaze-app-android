package com.winterprojects.tvmazeapp.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.winterprojects.tvmazeapp.common.helpers.OnItemClickListener
import com.winterprojects.tvmazeapp.databinding.FragmentHomeShowBinding
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeShowFragment : Fragment(), OnItemClickListener<ShowModel> {
    private lateinit var homeShowAdapter: HomeShowAdapter
    private lateinit var binding: FragmentHomeShowBinding

    private val homeShowViewModel: HomeShowViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeShowBinding.inflate(layoutInflater)

        initializeAdapter()
        initializeObservers()

        return binding.root
    }


    private fun initializeAdapter() {
        homeShowAdapter = HomeShowAdapter(this)
        binding.recyclerViewShows.apply {
            adapter = homeShowAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initializeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            whenCreated {
                homeShowViewModel.flowShows.collectLatest { pagingData ->
                    homeShowAdapter.submitData(pagingData)
                }
            }
        }
    }

    override fun onItemClick(showModel: ShowModel) {
        val action =
            HomeShowFragmentDirections.actionHomeShowFragmentToShowDetailsNavGraph(showModel.id)
        findNavController().navigate(action)
    }
}


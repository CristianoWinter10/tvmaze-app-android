package com.winterprojects.tvmazeapp.presentation.season

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.winterprojects.tvmazeapp.common.helpers.OnItemClickListener
import com.winterprojects.tvmazeapp.databinding.FragmentSeasonBinding
import com.winterprojects.tvmazeapp.domain.episodes.models.EpisodeModel
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.presentation.common.BundleKeys.BUNDLE_SHOW_ID_EXTRA
import com.winterprojects.tvmazeapp.presentation.show.ShowDetailsFragmentDirections
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class SeasonFragment : Fragment(), OnItemClickListener<EpisodeModel> {
    private lateinit var seasonViewModel: SeasonViewModel

    private lateinit var binding: FragmentSeasonBinding

    private lateinit var seasonAdapter: SeasonAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSeasonBinding.inflate(inflater, container, false)

        seasonViewModel = getViewModel {
            parametersOf(
                arguments?.getInt(
                    BUNDLE_SHOW_ID_EXTRA
                )
            )
        }

        seasonAdapter = SeasonAdapter(this)
        binding.recyclerSeason.apply {
            adapter = seasonAdapter
            layoutManager = LinearLayoutManager(context)
        }

        initializeObservers()

        return binding.root
    }

    private fun initializeObservers() {
        seasonViewModel.seasons.observe(viewLifecycleOwner) { resultSeason ->
            when (resultSeason) {
                is ResultState.Loaded -> {
                    seasonAdapter.submitList(resultSeason.data)
                }
            }
        }
    }

    override fun onItemClick(item: EpisodeModel) {
        val action =
            ShowDetailsFragmentDirections.actionShowDetailsFragmentToEpisodeDetailsFragment(item)
        findNavController().navigate(action)
    }

    companion object {
        const val TAG = "SeasonFragment"
    }
}
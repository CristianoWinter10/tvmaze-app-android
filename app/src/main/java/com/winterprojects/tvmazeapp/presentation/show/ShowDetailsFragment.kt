package com.winterprojects.tvmazeapp.presentation.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.winterprojects.tvmazeapp.R
import com.winterprojects.tvmazeapp.common.helpers.OnItemClickListener
import com.winterprojects.tvmazeapp.databinding.FragmentShowDetailsBinding
import com.winterprojects.tvmazeapp.domain.episodes.models.EpisodeModel
import com.winterprojects.tvmazeapp.domain.shows.models.ScheduleModel
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel
import com.winterprojects.tvmazeapp.presentation.common.BundleKeys.BUNDLE_SHOW_ID_EXTRA
import com.winterprojects.tvmazeapp.presentation.season.SeasonFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ShowDetailsFragment : Fragment(), OnItemClickListener<EpisodeModel> {
    private val args: ShowDetailsFragmentArgs by navArgs()
    private lateinit var binding: FragmentShowDetailsBinding


    private val dayTimeSeriesAirsFragment: DayTimeSeriesAirsFragment = DayTimeSeriesAirsFragment()
    private val seasonFragment: SeasonFragment = SeasonFragment()
    private val showDetailsViewModel: ShowDetailsViewModel by viewModel {
        parametersOf(
            args.showId
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addFragments()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowDetailsBinding.inflate(LayoutInflater.from(context), container, false)

        initializeObservers()

        initializeListeners()

        return binding.root
    }

    private fun addFragments() {
        childFragmentManager.apply {
            if (findFragmentByTag(DayTimeSeriesAirsFragment.TAG) == null) {
                commit {
                    replace(
                        R.id.frameLayoutDayTimeSeriesAirs,
                        dayTimeSeriesAirsFragment,
                        DayTimeSeriesAirsFragment.TAG
                    )
                }
            }

            if (findFragmentByTag(DayTimeSeriesAirsFragment.TAG) == null) {
                seasonFragment.arguments = Bundle().apply {
                    putInt(
                        BUNDLE_SHOW_ID_EXTRA, args.showId
                    )
                }
                commit {
                    replace(R.id.frameLayoutSeason, seasonFragment, SeasonFragment.TAG)

                }
            }
        }
    }

    private fun initializeListeners() {
        binding.imageBackButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.buttonFavorite.setOnClickListener {
            showDetailsViewModel.updateFavoriteStatus()
        }
    }

    private fun updateDayTimeSeriesAirsFragment(scheduleModel: ScheduleModel) {
        dayTimeSeriesAirsFragment.updateSchedule(scheduleModel)
    }

    private fun initializeObservers() {
        showDetailsViewModel.show.observe(viewLifecycleOwner) { show ->
            binding.show = show

            show.scheduleModel?.let { updateDayTimeSeriesAirsFragment(show.scheduleModel) }
        }
    }

    override fun onItemClick(episodeModel: EpisodeModel) {
        val action =
            ShowDetailsFragmentDirections.actionShowDetailsFragmentToEpisodeDetailsFragment(
                episodeModel
            )
        findNavController().navigate(action)
    }

}
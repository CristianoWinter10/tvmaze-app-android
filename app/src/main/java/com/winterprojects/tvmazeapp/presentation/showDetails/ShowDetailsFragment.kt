package com.winterprojects.tvmazeapp.presentation.showDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.navArgs
import com.winterprojects.tvmazeapp.R
import com.winterprojects.tvmazeapp.databinding.FragmentShowDetailsBinding
import com.winterprojects.tvmazeapp.domain.shows.models.ScheduleModel
import com.winterprojects.tvmazeapp.presentation.common.BundleKeys.SHOW_ID_EXTRA
import com.winterprojects.tvmazeapp.presentation.season.SeasonFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ShowDetailsFragment : Fragment() {
    private val args: ShowDetailsFragmentArgs by navArgs()

    private lateinit var binding: FragmentShowDetailsBinding

    private val dayTimeSeriesAirsFragment: DayTimeSeriesAirsFragment = DayTimeSeriesAirsFragment()
    private val seasonFragment: SeasonFragment = SeasonFragment()
    private val showDetailsViewModel: ShowDetailsViewModel by viewModel { parametersOf(args.tvShow) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowDetailsBinding.inflate(LayoutInflater.from(context), container, false)

        childFragmentManager.commit {
            replace(R.id.frameLayoutDayTimeSeriesAirs, dayTimeSeriesAirsFragment )

            seasonFragment.arguments = Bundle().apply {
                putInt(SHOW_ID_EXTRA, args.tvShow.show.id)
            }

            replace(R.id.frameLayoutSeason, seasonFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeObservers()

    }

    private fun updateDayTimeSeriesAirsFragment(scheduleModel: ScheduleModel) {
        dayTimeSeriesAirsFragment.updateSchedule(scheduleModel)
    }

    private fun initializeObservers() {
        showDetailsViewModel.tvShow.observe(viewLifecycleOwner) { tvShow ->
            binding.show = tvShow.show

            tvShow.show.scheduleModel?.let { updateDayTimeSeriesAirsFragment(it) }
        }
    }

}
package com.winterprojects.tvmazeapp.presentation.showDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.whenCreated
import com.winterprojects.tvmazeapp.databinding.FragmentDayTimeSeriesAirsBinding
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.shows.models.ScheduleModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DayTimeSeriesAirsFragment : Fragment() {

    private var dayTimeSeriesAirsAdapter = DayTimeSeriesAirsAdapter()
    lateinit var binding: FragmentDayTimeSeriesAirsBinding

    private val dayTimeSeriesAirsViewModel: DayTimeSeriesAirsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDayTimeSeriesAirsBinding.inflate(inflater, container, false)

        initializeRecyclerView()
        initializeObservers()

        return binding.root
    }

    private fun initializeObservers() {
        dayTimeSeriesAirsViewModel.schedule.observe(viewLifecycleOwner) { result ->
            when(result){
                ResultState.Empty -> showEmptyState()
                is ResultState.Loaded -> showLoadedState(result.data)
            }
        }
    }

    private fun showLoadedState(schedule: ScheduleModel) {
        binding.recyclerDayTimeSeriesAires.visibility = View.VISIBLE
        binding.textScheduleNotAvailable.visibility = View.GONE
        dayTimeSeriesAirsAdapter.updateSchedule(schedule)
    }

    private fun showEmptyState() {
        binding.recyclerDayTimeSeriesAires.visibility = View.GONE
        binding.textScheduleNotAvailable.visibility = View.VISIBLE
    }

    private fun initializeRecyclerView() {
        binding.recyclerDayTimeSeriesAires.adapter = dayTimeSeriesAirsAdapter
    }

    fun updateSchedule(scheduleModel: ScheduleModel) {
        dayTimeSeriesAirsViewModel.viewModelScope.launch {
            whenCreated {
                dayTimeSeriesAirsViewModel.updateSchedule(scheduleModel)
            }
        }
    }
}
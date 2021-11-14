package com.winterprojects.tvmazeapp.presentation.show

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.winterprojects.tvmazeapp.R
import com.winterprojects.tvmazeapp.databinding.ItemDayTimeSeriesAirsBinding
import com.winterprojects.tvmazeapp.domain.shows.models.ScheduleModel

class DayTimeSeriesAirsAdapter :
    RecyclerView.Adapter<DayTimeSeriesAirsAdapter.DayTimeSeriesAirsViewHolder>() {
    private var scheduleModel: ScheduleModel? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayTimeSeriesAirsViewHolder {
        val binding =
            ItemDayTimeSeriesAirsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayTimeSeriesAirsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DayTimeSeriesAirsViewHolder, position: Int) {
        holder.bind(scheduleModel?.days?.get(position), scheduleModel?.time)
    }

    override fun getItemCount(): Int {
        return  scheduleModel?.days?.size ?: 0
    }

    fun updateSchedule(scheduleModel: ScheduleModel) {
        this.scheduleModel = scheduleModel
        notifyDataSetChanged()
    }


    class DayTimeSeriesAirsViewHolder(private val binding: ItemDayTimeSeriesAirsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weekDay: String?, hour: String?) {
            binding.textViewItemDayWeekDay.text = weekDay?.let {
                if (weekDay.count() >= MAX_CHAR_QUANTITY_FROM_WEEK_DAY_NAME) {
                    weekDay.substring(0, MAX_CHAR_QUANTITY_FROM_WEEK_DAY_NAME)
                } else {
                    weekDay
                }
            }


            binding.textViewItemDayHour.text = if(hour.isNullOrBlank()){
                binding.root.context.getString(R.string.not_applicable)
            } else{
                hour
            }
        }

        companion object {
            private const val MAX_CHAR_QUANTITY_FROM_WEEK_DAY_NAME = 3
        }
    }


}
package com.winterprojects.tvmazeapp.presentation.di

import com.winterprojects.tvmazeapp.domain.episodes.models.EpisodeModel
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel
import com.winterprojects.tvmazeapp.presentation.episode.EpisodeDetailsViewModel
import com.winterprojects.tvmazeapp.presentation.search.SearchShowViewModel
import com.winterprojects.tvmazeapp.presentation.season.SeasonViewModel
import com.winterprojects.tvmazeapp.presentation.showDetails.DayTimeSeriesAirsViewModel
import com.winterprojects.tvmazeapp.presentation.showDetails.ShowDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationDI {
    val module = module {
        viewModel {
            SearchShowViewModel(get())
        }

        viewModel { (tvShow: TvShowModel) ->
            ShowDetailsViewModel(tvShow)
        }

        viewModel {
            DayTimeSeriesAirsViewModel()
        }

        viewModel { (showId: Int) ->
            SeasonViewModel(showId = showId, fetchSeasonUseCase = get())
        }

        viewModel { (episode: EpisodeModel) ->
            EpisodeDetailsViewModel(episode)
        }
    }
}
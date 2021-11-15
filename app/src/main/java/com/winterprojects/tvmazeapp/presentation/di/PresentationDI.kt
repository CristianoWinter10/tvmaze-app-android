package com.winterprojects.tvmazeapp.presentation.di

import com.winterprojects.tvmazeapp.domain.episodes.models.EpisodeModel
import com.winterprojects.tvmazeapp.presentation.episode.EpisodeDetailsViewModel
import com.winterprojects.tvmazeapp.presentation.favorite.FavoritesViewModel
import com.winterprojects.tvmazeapp.presentation.home.HomeShowViewModel
import com.winterprojects.tvmazeapp.presentation.search.SearchShowViewModel
import com.winterprojects.tvmazeapp.presentation.season.SeasonViewModel
import com.winterprojects.tvmazeapp.presentation.show.DayTimeSeriesAirsViewModel
import com.winterprojects.tvmazeapp.presentation.show.ShowDetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationDI {
    val module = module {
        viewModel {
            SearchShowViewModel(get())
        }

        viewModel { (showId: Int) ->
            ShowDetailsViewModel(showId, get(), get(), get())
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

        viewModel {
            FavoritesViewModel(get(), get(), get())
        }

        viewModel {
            HomeShowViewModel(get())
        }
    }
}
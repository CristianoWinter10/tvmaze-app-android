package com.winterprojects.tvmazeapp.business.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import com.winterprojects.tvmazeapp.domain.helpers.ResultState
import com.winterprojects.tvmazeapp.domain.season.SeasonModel
import java.lang.Exception

class FetchSeasonUseCaseImpl(private val showRepository: ShowRepository) : FetchSeasonUseCase {
    override suspend fun invoke(showId: Int): ResultState<List<SeasonModel>> {
        return try {
            val show = showRepository.fetchEpisodesByShowId(showId)

            val seasons = show._embedded?.episodes?.groupBy { episode ->
                episode.season
            }?.map { (seasonId, episodes) ->
                SeasonModel(seasonId, episodes)
            }

            seasons?.let {
                if (seasons.isNotEmpty()) {
                    ResultState.Loaded(seasons)
                } else {
                    ResultState.Empty
                }
            } ?: ResultState.Empty

        } catch (ex: Exception) {
            ResultState.ErrorState(ex.localizedMessage)
        }
    }
}
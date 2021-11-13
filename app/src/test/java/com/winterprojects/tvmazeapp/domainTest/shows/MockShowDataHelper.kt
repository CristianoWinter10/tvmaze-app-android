package com.winterprojects.tvmazeapp.domainTest.shows

import com.winterprojects.tvmazeapp.domain.shows.models.ImageModel
import com.winterprojects.tvmazeapp.domain.shows.models.RatingModel
import com.winterprojects.tvmazeapp.domain.shows.models.ShowModel
import com.winterprojects.tvmazeapp.domain.shows.models.TvShowModel

object MockShowDataHelper {
    val tvShowModel = TvShowModel(
        score = 8.5,
        show = ShowModel(
            averageRuntime = 60,
            ended = "1993-07-22",
            genres = listOf(
                "Action",
                "Adventure",
                "Anime",
                "Supernatural"
            ),
            id = 3616,
            image = ImageModel(
                medium = "Medium",
                original = "Original"
            ),
            language = "English",
            name = "Matrix",
            officialSite = "",
            premiered = "1993-03-01",
            rating = RatingModel(average = 6.7),
            status = "Ended",
            summary = "Steven Matrix is a freelance hitman who will...",
            weight = 0,
            _embedded = null
        )
    )


    val showModel = ShowModel(
        averageRuntime = 30,
        ended = "2021-10-16",
        genres = listOf(
            "Action",
            "Adventure",
            "Anime",
            "Supernatural"
        ),
        id = 1,
        image = ImageModel(
            medium = "Medium",
            original = "Original"
        ),
        language = "Chinese",
        name = "Grandmaster",
        officialSite = "",
        premiered = "2028-10-16",
        rating = RatingModel(average = 6.7),
        status = "Ended",
        summary = "As the grandmaster who founded...",
        weight = 0,
        _embedded = null
    )

    val ratingModel = RatingModel(
        average = 8.9
    )

    val imageModel = ImageModel(
        medium = "Medium Size",
        original = "Original Size"
    )
}
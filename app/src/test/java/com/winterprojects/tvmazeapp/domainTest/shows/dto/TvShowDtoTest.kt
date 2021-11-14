package com.winterprojects.tvmazeapp.domainTest.shows.dto

import com.winterprojects.tvmazeapp.domain.shows.dtos.*
import com.winterprojects.tvmazeapp.domainTest.shows.MockShowDataHelper
import org.junit.Assert
import org.junit.Test

class TvShowDtoTest {
    @Test
    fun `Should parse Tv Show Dto to Tv Show Model`() {

        //Arrange
        val tvShowDto = TvShowDto(
            score = 8.5,
            show = ShowDto(
                averageRuntime = 60,
                ended = "1993-07-22",
                genres = listOf(
                    "Action",
                    "Adventure",
                    "Anime",
                    "Supernatural"
                ),
                id = 3616,
                image = ImageDto(
                    medium = "Medium",
                    original = "Original"
                ),
                language = "English",
                name = "Matrix",
                officialSite = "",
                premiered = "1993-03-01",
                rating = RatingDto(average = 6.7f),
                status = "Ended",
                summary = "Steven Matrix is a freelance hitman who will...",
                weight = 0,
                _embedded = null,
                schedule = null
            )
        )

        //Act
        val tvShowModel = tvShowDto.toModel()

        //Assert
        Assert.assertEquals(MockShowDataHelper.tvShowModel, tvShowModel)

    }
}
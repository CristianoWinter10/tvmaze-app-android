package com.winterprojects.tvmazeapp.domainTest.shows.dto

import com.winterprojects.tvmazeapp.domain.shows.dtos.ImageDto
import com.winterprojects.tvmazeapp.domain.shows.dtos.RatingDto
import com.winterprojects.tvmazeapp.domain.shows.dtos.ShowDto
import com.winterprojects.tvmazeapp.domain.shows.dtos.toModel
import com.winterprojects.tvmazeapp.domainTest.shows.MockShowDataHelper
import org.junit.Assert
import org.junit.Test

class ShowModelTest {
    @Test
    fun `Should parse Show Dto to Show Model`() {

        //Arrange
        val showDto = ShowDto(
            averageRuntime = 30,
            ended = "2021-10-16",
            genres = listOf(
                "Action",
                "Adventure",
                "Anime",
                "Supernatural"
            ),
            id = 1,
            image = ImageDto(
                medium = "Medium",
                original = "Original"
            ),
            language = "Chinese",
            name = "Grandmaster",
            officialSite = "",
            premiered = "2028-10-16",
            rating = RatingDto(average = 6.7f),
            status = "Ended",
            summary = "As the grandmaster who founded...",
            weight = 0,
            _embedded = null,
            schedule = null
        )

        //Act
        val showModel = showDto.toModel()

        //Assert
        Assert.assertEquals(MockShowDataHelper.showModel, showModel)

    }
}
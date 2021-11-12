package com.winterprojects.tvmazeapp.domainTest.shows.dto

import com.winterprojects.tvmazeapp.domain.shows.dto.ImageDto
import com.winterprojects.tvmazeapp.domain.shows.dto.RatingDto
import com.winterprojects.tvmazeapp.domain.shows.dto.ShowDto
import com.winterprojects.tvmazeapp.domain.shows.dto.toModel
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
            rating = RatingDto(average = 6.7),
            status = "Ended",
            summary = "As the grandmaster who founded...",
            weight = 0
        )

        //Act
        val showModel = showDto.toModel()

        //Assert
        Assert.assertEquals(MockShowDataHelper.showModel, showModel)

    }
}
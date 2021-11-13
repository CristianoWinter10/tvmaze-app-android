package com.winterprojects.tvmazeapp.domainTest.shows.dto

import com.winterprojects.tvmazeapp.domain.shows.dtos.RatingDto
import com.winterprojects.tvmazeapp.domain.shows.dtos.toModel
import com.winterprojects.tvmazeapp.domainTest.shows.MockShowDataHelper
import org.junit.Assert
import org.junit.Test

class RatingDtoTest {
    @Test
    fun `Should parse Rating Dto to Rating Model`() {

        //Arrange
        val ratingDto = RatingDto(
            average = 8.9
        )

        //Act
        val ratingModel = ratingDto.toModel()

        //Assert
        Assert.assertEquals(MockShowDataHelper.ratingModel,  ratingModel)

    }
}
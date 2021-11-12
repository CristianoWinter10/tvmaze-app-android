package com.winterprojects.tvmazeapp.domainTest.dto

import com.winterprojects.tvmazeapp.domain.shows.dto.RatingDto
import com.winterprojects.tvmazeapp.domain.shows.dto.toModel
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
        Assert.assertEquals(MockModelsHelper.ratingModel,  ratingModel)

    }
}
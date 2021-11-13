package com.winterprojects.tvmazeapp.domainTest.shows.dto

import com.winterprojects.tvmazeapp.domain.shows.dtos.ImageDto
import com.winterprojects.tvmazeapp.domain.shows.dtos.toModel
import com.winterprojects.tvmazeapp.domainTest.shows.MockShowDataHelper
import org.junit.Assert
import org.junit.Test

class ImageDtoTest {

    @Test
    fun `Should parse Image Dto to Image Model`() {

        //Arrange
        val imageDto = ImageDto(
            medium = "Medium Size",
            original = "Original Size"
        )

        //Act
        val imageModel = imageDto.toModel()

        //Assert
        Assert.assertEquals(MockShowDataHelper.imageModel,  imageModel)

    }
}
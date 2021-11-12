package com.winterprojects.tvmazeapp.domainTest.dto

import com.winterprojects.tvmazeapp.domain.shows.dto.ImageDto
import com.winterprojects.tvmazeapp.domain.shows.dto.toModel
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
        Assert.assertEquals(MockModelsHelper.imageModel,  imageModel)

    }
}
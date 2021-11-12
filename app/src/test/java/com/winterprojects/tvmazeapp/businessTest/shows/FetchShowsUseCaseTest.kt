package com.winterprojects.tvmazeapp.businessTest.shows

import com.winterprojects.tvmazeapp.BaseTest
import com.winterprojects.tvmazeapp.business.shows.FetchShowsUseCase
import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.koin.test.inject
import org.koin.test.mock.declareMock
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.only

class FetchShowsUseCaseTest : BaseTest() {

    @Mock
    lateinit var showRepository: ShowRepository

    private val fetchShowsUseCase: FetchShowsUseCase by inject()

    @Before
    fun setup() {
        showRepository = declareMock()
    }

    @Test
    fun `Should fetch data from Show Repository`() {
        runBlocking {

            // Arrange
            Mockito.`when`(showRepository.fetchShowsByName(Mockito.anyString()))
                .thenReturn(listOf())

            // Act
            fetchShowsUseCase(anyString())

            // Assert
            Mockito.verify(showRepository, only()).fetchShowsByName(anyString())

        }
    }

}
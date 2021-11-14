package com.winterprojects.tvmazeapp.businessTest.shows

import com.winterprojects.tvmazeapp.BaseTest
import com.winterprojects.tvmazeapp.business.search.FetchShowsUseCase
import com.winterprojects.tvmazeapp.datasource.search.SearchRepository
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
    lateinit var searchRepository: SearchRepository

    private val fetchShowsUseCase: FetchShowsUseCase by inject()

    @Before
    fun setup() {
        searchRepository = declareMock()
    }

    @Test
    fun `Should fetch data from Show Repository`() {
        runBlocking {

            // Arrange
            Mockito.`when`(searchRepository.fetchShowsByName(Mockito.anyString()))
                .thenReturn(listOf())

            // Act
            fetchShowsUseCase(anyString())

            // Assert
            Mockito.verify(searchRepository, only()).fetchShowsByName(anyString())

        }
    }

}
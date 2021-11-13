package com.winterprojects.tvmazeapp.datasourceTest.shows

import com.winterprojects.tvmazeapp.datasource.search.SearchClientApi
import com.winterprojects.tvmazeapp.datasource.search.SearchRemoteDatasource
import com.winterprojects.tvmazeapp.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.koin.core.component.inject
import org.koin.test.mock.declareMock
import org.mockito.Mock
import org.mockito.Mockito.*

class SearchRemoteDatasourceTest : BaseTest() {
    @Mock
    private lateinit var searchClientApi: SearchClientApi

    private val showRemoteDatasource: SearchRemoteDatasource by inject()

    @Before
    fun setup(){
        searchClientApi = declareMock()
    }

    @Test
    fun `Should call fetchShowsByName method from Show Api Client`() {
        runBlocking {

            //Assert
            `when`(searchClientApi.fetchShowsByName(anyString())).thenReturn(listOf())

            //Act
            showRemoteDatasource.fetchShowsByName("")

            //Assert
            verify(searchClientApi, only()).fetchShowsByName(anyString())
        }
    }
}
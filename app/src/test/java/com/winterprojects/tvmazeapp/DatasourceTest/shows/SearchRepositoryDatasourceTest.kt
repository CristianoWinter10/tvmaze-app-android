package com.winterprojects.tvmazeapp.datasourceTest.shows

import com.winterprojects.tvmazeapp.BaseTest
import com.winterprojects.tvmazeapp.datasource.search.SearchRemoteDatasource
import com.winterprojects.tvmazeapp.datasource.search.SearchRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.koin.core.component.inject
import org.koin.test.mock.declareMock
import org.mockito.Mock
import org.mockito.Mockito.*

class SearchRepositoryDatasourceTest : BaseTest() {
    @Mock
    private lateinit var showRemoteDatasource: SearchRemoteDatasource

    private val searchRepository: SearchRepository by inject()

    @Before
    fun setup(){
        showRemoteDatasource = declareMock()
    }

    @Test
    fun `Should call fetchShowsByName method by Remote Datasource `() {
        runBlocking {

            //Assert
            `when`(showRemoteDatasource.fetchShowsByName(anyString())).thenReturn(listOf())

            //Act
            searchRepository.fetchShowsByName("")

            //Assert
            verify(showRemoteDatasource, only()).fetchShowsByName(anyString())
        }
    }
}
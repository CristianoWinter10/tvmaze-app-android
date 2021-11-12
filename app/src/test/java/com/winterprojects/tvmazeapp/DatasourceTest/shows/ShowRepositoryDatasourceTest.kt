package com.winterprojects.tvmazeapp.datasourceTest.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowClientApi
import com.winterprojects.tvmazeapp.datasource.shows.ShowRemoteDatasource
import com.winterprojects.tvmazeapp.BaseTest
import com.winterprojects.tvmazeapp.datasource.shows.ShowRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.koin.core.component.inject
import org.koin.test.mock.declareMock
import org.mockito.Mock
import org.mockito.Mockito.*

class ShowRepositoryDatasourceTest : BaseTest() {
    @Mock
    private lateinit var showRemoteDatasource: ShowRemoteDatasource

    private val showRepository: ShowRepository by inject()

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
            showRepository.fetchShowsByName("")

            //Assert
            verify(showRemoteDatasource, only()).fetchShowsByName(anyString())
        }
    }
}
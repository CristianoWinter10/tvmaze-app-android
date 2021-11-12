package com.winterprojects.tvmazeapp.datasourceTest.shows

import com.winterprojects.tvmazeapp.datasource.shows.ShowClientApi
import com.winterprojects.tvmazeapp.datasource.shows.ShowRemoteDatasource
import com.winterprojects.tvmazeapp.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.koin.core.component.inject
import org.koin.test.mock.declareMock
import org.mockito.Mock
import org.mockito.Mockito.*

class ShowRemoteDatasourceTest : BaseTest() {
    @Mock
    private lateinit var showClientApi: ShowClientApi

    private val showRemoteDatasource: ShowRemoteDatasource by inject()

    @Before
    fun setup(){
        showClientApi = declareMock()
    }

    @Test
    fun `Should call fetchShowsByName method from Show Api Client`() {
        runBlocking {

            //Assert
            `when`(showClientApi.fetchShowsByName(anyString())).thenReturn(listOf())

            //Act
            showRemoteDatasource.fetchShowsByName("")

            //Assert
            verify(showClientApi, only()).fetchShowsByName(anyString())
        }
    }
}
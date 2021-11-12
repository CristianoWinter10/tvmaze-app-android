package com.winterprojects.tvmazeapp.domainTest.repositories

import com.winterprojects.tvmazeapp.datasource.shows.ShowClientApi
import com.winterprojects.tvmazeapp.datasource.shows.ShowRemoteDatasource
import com.winterprojects.tvmazeapp.domainTest.BaseTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.component.inject
import org.koin.test.mock.declareMock
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

class ShowRepositoryRemoteModuleTest : BaseTest() {
    @Mock
    private lateinit var showClientApi: ShowClientApi

    private val showRemoteDatasource: ShowRemoteDatasource by inject()

    @Before
    fun setup(){
        showClientApi = declareMock()
    }

    @Test
    fun `Should call Show Api Client`() {
        runBlocking {

            //Assert
            `when`(showClientApi.fetchShowByName(anyString())).thenReturn(listOf())

            //Act
            showRemoteDatasource.fetchShowsByName("")

            //Assert
            verify(showClientApi, only()).fetchShowByName(anyString())
        }
    }
}
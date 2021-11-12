package com.winterprojects.tvmazeapp

import com.winterprojects.tvmazeapp.common.di.KoinModules
import org.junit.Rule
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.mock.MockProviderRule
import org.mockito.Mockito

abstract class BaseTest: KoinTest {
    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(
            KoinModules.applicationModules
        )
    }

    @get:Rule
    val mockProvider = MockProviderRule.create { clazz ->
        Mockito.mock(clazz.java)
    }
}
package com.winterprojects.tvmazeapp.common.di

import com.winterprojects.tvmazeapp.datasource.di.DatasourceDI
import com.winterprojects.tvmazeapp.datasource.di.RemoteDI
import com.winterprojects.tvmazeapp.datasource.di.RetrofitDI
import org.koin.core.module.Module

object KoinModules {
    val applicationModules = listOf(
        DatasourceDI.module,
        RemoteDI.module,
        RetrofitDI.module
    )
}
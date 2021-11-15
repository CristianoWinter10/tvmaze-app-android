package com.winterprojects.tvmazeapp.common.di

import com.winterprojects.tvmazeapp.business.di.BusinessDI
import com.winterprojects.tvmazeapp.datasource.di.DatabaseDI
import com.winterprojects.tvmazeapp.datasource.di.DatasourceDI
import com.winterprojects.tvmazeapp.datasource.di.RemoteDI
import com.winterprojects.tvmazeapp.datasource.di.RetrofitDI
import com.winterprojects.tvmazeapp.presentation.di.PresentationDI

object KoinModules {
    val applicationModules = listOf(
        DatasourceDI.module,
        RemoteDI.module,
        RetrofitDI.module,
        BusinessDI.module,
        PresentationDI.module,
        DatabaseDI.module
    )
}
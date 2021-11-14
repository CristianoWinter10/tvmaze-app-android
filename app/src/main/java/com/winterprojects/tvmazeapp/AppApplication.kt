package com.winterprojects.tvmazeapp

import android.app.Application
import com.winterprojects.tvmazeapp.common.di.KoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AppApplication)
            modules(
                KoinModules.applicationModules
            )
        }
    }
}
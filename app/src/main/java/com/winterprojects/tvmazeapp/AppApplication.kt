package com.winterprojects.tvmazeapp

import android.app.Application
import com.winterprojects.tvmazeapp.common.di.KoinModules
import org.koin.core.context.startKoin

class AppApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                KoinModules.applicationModules
            )
        }
    }
}
package com.winterprojects.tvmazeapp.presentation.di

import com.winterprojects.tvmazeapp.presentation.search.SearchShowViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationDI {
    val module = module {
        viewModel {
            SearchShowViewModel(get())
        }
    }
}
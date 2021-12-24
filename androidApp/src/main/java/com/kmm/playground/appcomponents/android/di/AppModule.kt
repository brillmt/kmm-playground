package com.kmm.playground.appcomponents.android.di

import com.kmm.playground.appcomponents.android.viewmodels.CryptoViewModel
import com.kmm.playground.appcomponents.android.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { CryptoViewModel(get()) }
}

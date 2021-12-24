package com.kmm.playground.appcomponents.android

import android.app.Application
import com.kmm.playground.appcomponents.android.di.appModule
import com.kmm.playground.appcomponents.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent

class PlaygroundApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@PlaygroundApplication)
            modules(appModule)
        }

    }
}
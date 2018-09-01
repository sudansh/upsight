package com.sudansh.upsight

import android.app.Application
import com.sudansh.upsight.di.appModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(listOf(appModule))
    }
}
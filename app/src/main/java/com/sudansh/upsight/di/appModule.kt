package com.sudansh.upsight.di

import com.sudansh.upsight.utils.Prefs
import com.upsight.android.BuildConfig
import com.upsight.android.Upsight
import com.upsight.android.logger.UpsightLogger
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext
import java.util.*

val appModule = applicationContext {
    bean { Prefs(androidApplication()) }
    bean {
        Upsight.createContext(androidApplication()).apply {
            if (BuildConfig.DEBUG)
                logger.setLogLevel(Upsight.LOG_TAG, EnumSet.allOf(UpsightLogger.Level::class.java))
        }
    }
}
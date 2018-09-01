package com.sudansh.upsight.di

import com.upsight.android.Upsight
import com.upsight.android.UpsightContext
import com.upsight.android.logger.UpsightLogger
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext
import java.util.*

val appModule = applicationContext {
    bean {
        Upsight.createContext(androidApplication()).apply {
            logger.setLogLevel(Upsight.LOG_TAG, EnumSet.allOf(UpsightLogger.Level::class.java))
        } as UpsightContext
    }
}
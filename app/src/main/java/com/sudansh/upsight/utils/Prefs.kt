package com.sudansh.upsight.utils

import android.app.Application
import android.content.Context

class Prefs(context: Application) {
    private val prefs by lazy { context.getSharedPreferences("upsight", Context.MODE_PRIVATE)!! }

    fun write(key: String, value: Any?) {
        when (value) {
            is String -> prefs.edit().putString(key, value).apply()
            is Int -> prefs.edit().putInt(key, value).apply()
        }
    }

    fun getInt(key: String, default: Int = 0) = prefs.getInt(key, default)
    fun getString(key: String, default: String = "") = prefs.getString(key, default).orEmpty()
}
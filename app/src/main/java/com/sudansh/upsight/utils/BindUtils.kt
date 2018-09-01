package com.sudansh.upsight.utils

import android.databinding.BindingAdapter
import android.widget.EditText
import android.widget.TextView


object BindUtils {

    @JvmStatic
    @BindingAdapter("android:text")
    fun convertIntToString(v: TextView, i: Int) {
        v.text = i.toString()
    }

    @JvmStatic
    @BindingAdapter("android:text")
    fun convertIntToString(v: EditText, i: Int) {
        v.setText(i.toString())
    }

}
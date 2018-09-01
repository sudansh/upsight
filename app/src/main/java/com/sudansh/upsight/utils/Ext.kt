package com.sudansh.upsight.utils

import android.support.design.widget.TextInputLayout

fun TextInputLayout?.getText() = this?.editText?.text.toString()
package com.sudansh.upsight.ui

import android.databinding.BaseObservable
import android.databinding.ObservableInt
import com.sudansh.upsight.utils.ObservableString

class LoginViewModel : BaseObservable() {

    val name = ObservableString()
    val age = ObservableInt()
    val gender = ObservableString()

    val managedName = ObservableString()
    val managedCoins = ObservableInt()

}

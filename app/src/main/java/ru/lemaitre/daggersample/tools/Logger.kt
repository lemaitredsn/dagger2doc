package ru.lemaitre.daggersample.tools

import android.util.Log

object Logger {
    fun execute(message:String) = Log.e("TAG", message)
}
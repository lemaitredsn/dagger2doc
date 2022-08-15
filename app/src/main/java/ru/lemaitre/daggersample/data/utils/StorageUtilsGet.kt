package ru.lemaitre.daggersample.data.utils

import ru.lemaitre.daggersample.tools.Logger

class StorageUtilsGet {
    init {
        println("StorageUtilsGet was init")
    }

    fun get() = Logger.execute("storage utils")
}
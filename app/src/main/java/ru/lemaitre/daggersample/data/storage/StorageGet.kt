package ru.lemaitre.daggersample.data.storage

import ru.lemaitre.daggersample.tools.Logger

class StorageGet {
    init {
        println("StorageGet was init")
    }

    fun get() = Logger.execute("storageGet")
}
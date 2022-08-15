package ru.lemaitre.daggersample.data.storage

import javax.inject.Inject

class StorageInject @Inject constructor() {
    init {
        println("storageInject was init")
    }

    fun execute() = println("$this method execute done")
}
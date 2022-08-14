package ru.lemaitre.daggersample.data

import ru.lemaitre.daggersample.data.storage.StorageGet
import ru.lemaitre.daggersample.data.utils.StorageUtilsGet

class StorageGetRepository(
    private val storageGet: StorageGet,
    private val storageUtilsGet: StorageUtilsGet
) {
    init {
        println("storage get repository created")
    }

}
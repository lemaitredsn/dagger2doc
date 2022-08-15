package ru.lemaitre.daggersample.data

import ru.lemaitre.daggersample.tools.Logger

/**
 * Объекту [DBRepository] требуется на вход два объекта
 * этот объект даггер знает как создать с помощью гет метода в модуле [StorageModule]
 * */


class DBRepository(
    private val storageInjectRepository: StorageInjectRepository,
    private val storageGetRepository: StorageGetRepository
) {
    fun execute(){
        Logger.execute("DBRepository invoke get and inject repo methods")
        storageGetRepository.execute()
        storageInjectRepository.loadData()
    }
}
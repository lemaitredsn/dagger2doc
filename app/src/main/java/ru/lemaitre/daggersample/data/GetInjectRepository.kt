package ru.lemaitre.daggersample.data

import ru.lemaitre.daggersample.data.storage.StorageGet
import ru.lemaitre.daggersample.data.storage.StorageInject
import javax.inject.Inject

/**
 * [GetInjectRepository] даггер сможет создать этот объект
 * потому как он знает что [StorageGet] предоставляется с помощью гет метода
 * а [StorageInject] с помощью inject в конструктор
 * */

class GetInjectRepository @Inject constructor(
    private val get: StorageGet,
    private val inject: StorageInject
) {

    fun execute(){
        get.get()
        inject.execute()
    }

}
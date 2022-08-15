package ru.lemaitre.daggersample.data

import ru.lemaitre.daggersample.data.storage.StorageInject
import ru.lemaitre.daggersample.tools.Logger
import javax.inject.Inject

/**
 * аннотация инжект позволяет внедрить зависмость указанную в
 * конструкторе, если объект простой и например ему ничего не требуется
 * на вход в конструктор то даггер сможет создать объект помеченный аннотацией inject
 *
 * Если внедряеммый объект есть в гет методе модуля то даггер его внедрит
 * Если внедряеммый объект простой и он помечен аннот.инжект то даггер его внедрит
 * Если мы используем инжект аннотацию на конструкторе то даггер внедрит объекты
 * те которые есть у него в графе.
 * Даггер создает объекты с аннотацией инжект неявно, т.е. для внедрения зависимости
 * емк не нужен гет метод в модулях.
 *
 * Например [StorageInjectRepository] требуется только [storageInject]
 * конструктор которого тоже помечен аннотацией inject но [storageInject]
 * для создания ничего не требуется, такой объект даггер сможет создать сам
 * и поместить в граф
 *
 * */
class StorageInjectRepository @Inject constructor(
    private val storageInject: StorageInject
) {
    init {
        Logger.execute("$this StorageInjectRepository was init")
    }

    fun loadData() = Logger.execute("$this loadData executed")
}
package ru.lemaitre.daggersample.di

import dagger.Module
import dagger.Provides
import ru.lemaitre.daggersample.data.StorageGetRepository
import ru.lemaitre.daggersample.data.storage.StorageGet
import ru.lemaitre.daggersample.data.utils.StorageUtilsGet

@Module
class StorageGetModule {

    /**
     * Для создания StorageGetRepository
     * требуется два объекта (StorageGet, StorageUtilsGet),
     * StorageGetRepository - мы будем получать у
     * компонента с помощью гет метода
     * Чтобы даггер смог создать объект StorageGetRepository
     * необходимо чтобы он знал как создать эти два объекта,
     * поэтому создадим их в этом же модуле
     * */
    @Provides
    fun provideSGR(
        storageGet: StorageGet,
        storageUtilsGet: StorageUtilsGet
    ): StorageGetRepository {
        return StorageGetRepository(storageGet, storageUtilsGet)
    }

    @Provides
    fun provideStorageGet() = StorageGet()

    @Provides
    fun provideStorageUtilsGet() = StorageUtilsGet()
}
package ru.lemaitre.daggersample.di

import dagger.Module
import dagger.Provides
import ru.lemaitre.daggersample.data.DBRepository
import ru.lemaitre.daggersample.data.StorageGetRepository
import ru.lemaitre.daggersample.data.StorageInjectRepository

@Module
class StorageModule {

    @Provides
    fun provideDBRepository(
        storageGetRepository: StorageGetRepository,
        storageInjectRepository: StorageInjectRepository
    ): DBRepository {
        return DBRepository(storageInjectRepository, storageGetRepository)
    }
}
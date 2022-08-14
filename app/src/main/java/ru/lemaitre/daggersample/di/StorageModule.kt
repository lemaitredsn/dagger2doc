package ru.lemaitre.daggersample.di

import dagger.Module
import dagger.Provides
import ru.lemaitre.daggersample.data.DBRepository

@Module
class StorageModule {

    @Provides
    fun provideDBRepository(): DBRepository {
        return DBRepository()
    }
}
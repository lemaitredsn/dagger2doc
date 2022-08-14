package ru.lemaitre.daggersample.di

import dagger.Module
import dagger.Provides
import ru.lemaitre.daggersample.data.NetworkRepository

/**
 * аннотация @Module определяет
 * этот класс как даггер модуль
 */
@Module
class NetworkModule {
    /**
     * метод с аннотацией @Provides является
     * поставщиком объектов
     * */
    @Provides
    fun provideNetworkRepository(): NetworkRepository {
        return NetworkRepository()
    }
}
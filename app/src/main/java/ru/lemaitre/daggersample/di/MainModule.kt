package ru.lemaitre.daggersample.di

import dagger.Module
import dagger.Provides
import ru.lemaitre.daggersample.mvp.MainPresenter

@Module
class MainModule {
    @Provides
    fun provideMainPresenter(): MainPresenter {
        return MainPresenter()
    }
}
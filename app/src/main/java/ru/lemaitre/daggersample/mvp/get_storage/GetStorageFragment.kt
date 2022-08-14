package ru.lemaitre.daggersample.mvp.get_storage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ru.lemaitre.daggersample.R
import ru.lemaitre.daggersample.application.DaggerSampleApp
import ru.lemaitre.daggersample.data.StorageGetRepository
import ru.lemaitre.daggersample.di.AppComponent

class GetStorageFragment: Fragment(R.layout.fragment_get_storage) {
    private lateinit var appComponent: AppComponent
    private lateinit var getStorage: StorageGetRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /**
         * Получаем компонент
         * */
        appComponent = (activity?.applicationContext as DaggerSampleApp).appComponent
        /**
         * Смотрим логи что действительно объекты были созданы
         * */
        getStorage = appComponent.provideStorageGetRepository()
    }
}
package ru.lemaitre.daggersample.mvp.inject_storage

import android.os.Bundle
import androidx.fragment.app.Fragment
import ru.lemaitre.daggersample.MainActivity
import ru.lemaitre.daggersample.application.DaggerSampleApp
import ru.lemaitre.daggersample.data.*
import ru.lemaitre.daggersample.data.storage.StorageInject
import ru.lemaitre.daggersample.di.AppComponent
import ru.lemaitre.daggersample.di.DaggerAppComponent
import javax.inject.Inject

class InjectStorageFragment : Fragment() {

    lateinit var appComponent: AppComponent

    /**
     * Выполняется инжект в свойство класса
     * [injectRepository] - не имеет явных get методов
     * в модулях, все этого зависмости создаются с помощью inject в конструктор
     * [StorageInjectRepository] - зависит от [StorageInject]
     * но никто из этих двух не иммеет get методов в модулях,
     * даггер знает как их создать и создает граф самостоятельно
     */
    @Inject
    lateinit var injectRepository: StorageInjectRepository

    /**
     * Для примера выполняем inject [NetworkRepository]
     * который имеет get метод в networkModule
     * */
    @Inject
    lateinit var networkRepository: NetworkRepository

    /**
     * Для [dbRepository] зависит и от гет и от инжект репозитория
     * но ничто не мешает использовать аннотацию inject для получения
     * экземпляра в поле класса, в конструкторе класса могут быть и инжект и
     * объекты которые создаются через гет методы, даггер если знаект как их
     * создать то возьмет из графа и внедрит
     * [dbRepository] - даггер создаст из гет метода [StorageModule]
     * */
    @Inject
    lateinit var dbRepository: DBRepository

    /**
     * [getInjectRepository] получит зависимости с помощью inject в конструктор
     * объекты на вход получит и из инжект и из гет модуля
     * */
    @Inject
    lateinit var getInjectRepository: GetInjectRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appComponent = (activity?.application as DaggerSampleApp)
            .appComponent

        appComponent.injectRepository(this)

        injectRepository.loadData()
        networkRepository.execute()
        dbRepository.execute()

        getInjectRepository.execute()
    }
}
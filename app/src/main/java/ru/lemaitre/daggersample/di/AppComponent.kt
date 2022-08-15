package ru.lemaitre.daggersample.di

import dagger.Component
import dagger.Provides
import ru.lemaitre.daggersample.MainActivity
import ru.lemaitre.daggersample.data.DBRepository
import ru.lemaitre.daggersample.data.NetworkRepository
import ru.lemaitre.daggersample.data.StorageGetRepository
import ru.lemaitre.daggersample.data.storage.StorageGet
import ru.lemaitre.daggersample.data.utils.StorageUtilsGet
import ru.lemaitre.daggersample.mvp.inject_storage.InjectStorageFragment

/**
 * Даггер с помощь аннатоции @Component найдет этот интерфейс и
 * сгенерирует класс - реализацию компонента,
 * этот класс и будет источником требуемых классов
 * в приложении, Даггер генерирует компонент
 * в таком виде Dagger + "название интерфеса помеченного аннотацией @Component"
 * в данном случае  будет выглядеть так DaggerAppComponent
 * класс даггера необходимо создать в классе Application
 * */

/**
 * Даггер умеет создавать графы
 * если объекту для создания требуется
 * другой объект и этот объект есть модулях компонента
 * то даггер создаст объект
 * пример StorageGetModule
 * */

@Component(
    /**
     * Тут указываются модули из которых даггер будет доставать объекты
     *  внутри модулей описывается как создаются запрашиваемы объекты
     * */
    modules = [
        NetworkModule::class,
        StorageModule::class,
        MainModule::class,
        StorageGetModule::class
    ]
)
interface AppComponent {

    /**
     * метод возвращающий репозиторий название метода
     * может быть любым
     * */
    fun getNetworkRepos(): NetworkRepository

    /**
     * Компонент возвращает объекты, которые указаны в модулях компонента
     * в этих модулях должно быть описание как создавать объекты
     * */
    fun getDBRepo(): DBRepository

    /**
     * inject метод */
    fun injectInMainActivity(activity: MainActivity)

    /**
     * ПРимер get метода для объекта которому требуются другие объекты
     * в конструктор для создания, в модуле
     * StorageGetModule будут созданы эти объект
     * их возьмет даггер и предоставит для
     * создания репозитория см GetStorageFragment
     * */
    fun provideStorageGetRepository(): StorageGetRepository

    fun injectRepository(fragment: InjectStorageFragment)
}
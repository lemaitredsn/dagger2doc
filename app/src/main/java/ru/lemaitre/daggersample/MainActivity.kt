package ru.lemaitre.daggersample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.lemaitre.daggersample.application.DaggerSampleApp
import ru.lemaitre.daggersample.di.AppComponent
import ru.lemaitre.daggersample.mvp.MainPresenter
import ru.lemaitre.daggersample.mvp.menu.MenuFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var appComponent: AppComponent

    /**
     * пример для inject метод
     * помечаем аннотацией инжект тот объект который
     * требуется предоставить в объект MainActivity
     * даггер найдет его в модулях и предоставит сюда
     * */
    @Inject
    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Получение appComponent в активити
         * */
        appComponent = (application as DaggerSampleApp).appComponent
        /**
         * Получение репозитория с помощью гет метода, определенного в компоненте
         * */
//        val networkRepos = appComponent.getNetworkRepos()

        /**
         * @Inject - аннотация которая сообщает даггеру
         * что в этот объект необходимо предоставить
         * объекты которые помечены аннотацией inject
         * в компоненте указывем метод (название может быть любое)
         * и создаем инжект метод который будет принимать
         * на вход класс в который необходимо выполнить inject
         *
         * получаем и метод инжекта из компонена
         * */
        appComponent.injectInMainActivity(this)
        /**
         * вызовем тестовый метод presenterа
         * */
        presenter.printHelloWorld()

        supportFragmentManager.beginTransaction()
            .add(R.id.main_content, MenuFragment())
            .commit()
    }
}

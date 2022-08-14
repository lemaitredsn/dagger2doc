package ru.lemaitre.daggersample.application

import android.app.Application
import ru.lemaitre.daggersample.di.AppComponent
import ru.lemaitre.daggersample.di.DaggerAppComponent

class DaggerSampleApp : Application() {
    /** Создание аппкомпонента:*/
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        /** При первом запуске DaggerAppComponent - будет подсвечивать ошибкой
         * т.к. этого объекта еще не существует
         * поэтому необходимо собрать проект чтобы даггер сгенерировал этот объект
         */
        appComponent = DaggerAppComponent.create()

    }
}
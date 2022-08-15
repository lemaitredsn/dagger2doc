package ru.lemaitre.daggersample.data

import ru.lemaitre.daggersample.tools.Logger

class NetworkRepository {
    fun execute() = Logger.execute("$this fun execute executed")
}
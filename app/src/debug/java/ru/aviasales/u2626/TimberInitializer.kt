package ru.aviasales.u2626

import timber.log.Timber

object TimberInitializer {

    fun init() {
        Timber.plant(Timber.DebugTree())
    }
}

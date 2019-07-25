package ru.aviasales.u2626

import android.app.Application
import android.content.Context
import ru.aviasales.u2626.di.AppComponent
import ru.aviasales.u2626.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        TimberInitializer.init()
        FlipperInitializer.init(this)
        appComponent = DaggerAppComponent.factory().create(this)
    }

    companion object {
        fun from(context: Context) = context.applicationContext as App
    }
}

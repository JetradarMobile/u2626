package ru.aviasales.u2626.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.aviasales.core.autocomplete.di.AutocompleteApiModule
import ru.aviasales.u2626.MainActivity
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AutocompleteApiModule::class
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}

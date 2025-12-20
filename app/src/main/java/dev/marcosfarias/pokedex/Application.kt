package dev.marcosfarias.pokedex

import android.app.Application
import dev.marcosfarias.pokedex.di.appComponent
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDI()
    }

    private fun configureDI() = startKoin {
        androidContext(this@Application)
        modules(appComponent)
    }
}

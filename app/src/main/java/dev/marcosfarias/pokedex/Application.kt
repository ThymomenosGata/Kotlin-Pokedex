package dev.marcosfarias.pokedex

import android.app.Application
import dev.marcosfarias.pokedex.di.dataModule
import dev.marcosfarias.pokedex.di.domainModule
import dev.marcosfarias.pokedex.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : Application() {

    private val appComponent = listOf(
        dataModule,
        domainModule,
        presentationModule
    )

    override fun onCreate() {
        super.onCreate()
        configureDI()
    }

    private fun configureDI() = startKoin {
        androidContext(this@Application)
        modules(appComponent)
    }
}

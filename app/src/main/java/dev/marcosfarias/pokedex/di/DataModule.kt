package dev.marcosfarias.pokedex.di

import dev.marcosfarias.pokedex.data.local.AppDatabase
import dev.marcosfarias.pokedex.data.remote.api.ApiClient
import dev.marcosfarias.pokedex.data.repository.PokemonRepositoryImpl
import dev.marcosfarias.pokedex.domain.repository.PokemonRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    single { AppDatabase.getInstance(androidApplication()) }

    single { ApiClient.getApi() }

    singleOf(::PokemonRepositoryImpl).bind(PokemonRepository::class)
}
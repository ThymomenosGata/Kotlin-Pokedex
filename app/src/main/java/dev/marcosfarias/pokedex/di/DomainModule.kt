package dev.marcosfarias.pokedex.di

import dev.marcosfarias.pokedex.domain.use_case.GetPokemonByIdUseCase
import dev.marcosfarias.pokedex.domain.use_case.SavePokemonListUseCase
import dev.marcosfarias.pokedex.domain.use_case.SavePokemonUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    singleOf(::GetPokemonByIdUseCase).bind(GetPokemonByIdUseCase::class)
    singleOf(::SavePokemonUseCase).bind(SavePokemonUseCase::class)
    singleOf(::SavePokemonListUseCase).bind(SavePokemonListUseCase::class)
}
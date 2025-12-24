package dev.marcosfarias.pokedex.di

import dev.marcosfarias.pokedex.domain.use_case.GetAllPokemonsUseCase
import dev.marcosfarias.pokedex.domain.use_case.GetPokemonByIdUseCase
import dev.marcosfarias.pokedex.domain.use_case.GetPokemonEvolutionsUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val domainModule = module {
    singleOf(::GetPokemonByIdUseCase).bind(GetPokemonByIdUseCase::class)
    singleOf(::GetAllPokemonsUseCase).bind(GetAllPokemonsUseCase::class)
    singleOf(::GetPokemonEvolutionsUseCase).bind(GetPokemonEvolutionsUseCase::class)
}
package dev.marcosfarias.pokedex.di

import dev.marcosfarias.pokedex.presentation.ui.dashboard.DashboardViewModel
import dev.marcosfarias.pokedex.presentation.ui.dashboard.about.AboutViewModel
import dev.marcosfarias.pokedex.presentation.ui.dashboard.evolution.EvolutionViewModel
import dev.marcosfarias.pokedex.presentation.ui.dashboard.stats.StatsViewModel
import dev.marcosfarias.pokedex.presentation.ui.generation.GenerationViewModel
import dev.marcosfarias.pokedex.presentation.ui.home.HomeViewModel
import dev.marcosfarias.pokedex.presentation.ui.pokedex.PokedexViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::DashboardViewModel) { DashboardViewModel::class.java }
    viewModelOf(::GenerationViewModel) { GenerationViewModel::class.java }
    viewModelOf(::HomeViewModel) { HomeViewModel::class.java }
    viewModelOf(::PokedexViewModel) { PokedexViewModel::class.java }
    viewModelOf(::AboutViewModel) { AboutViewModel::class.java }
    viewModelOf(::StatsViewModel) { StatsViewModel::class.java }
    viewModelOf(::EvolutionViewModel) { EvolutionViewModel::class.java }
}
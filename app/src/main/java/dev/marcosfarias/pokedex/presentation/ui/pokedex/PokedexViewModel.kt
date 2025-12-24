package dev.marcosfarias.pokedex.presentation.ui.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.marcosfarias.pokedex.domain.entity.Result
import dev.marcosfarias.pokedex.domain.use_case.GetAllPokemonsUseCase
import dev.marcosfarias.pokedex.presentation.model.UIPokemonItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokedexViewModel(
    private val getAllPokemonsUseCase: GetAllPokemonsUseCase
) : ViewModel() {

    private val _allPokemons = MutableStateFlow<List<UIPokemonItem>>(listOf())
    val allPokemons: StateFlow<List<UIPokemonItem>>
        get() = _allPokemons

    init {
        loadPokemons()
    }

    private fun loadPokemons() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllPokemonsUseCase().collect { result ->
                when (result) {
                    is Result.Success -> {
                        val pokemonList = result.data?.map {
                            UIPokemonItem(
                                id = it.id,
                                name = it.name,
                                typeOfPokemon = it.typeOfPokemon,
                                imageUrl = it.imageUrl
                            )
                        } ?: listOf()
                        _allPokemons.emit(pokemonList)
                    }

                    is Result.Failure -> {
                        //todo сделать обработку ошибок
                    }

                    is Result.State -> {
                        //todo сделать обработку стейтов
                    }
                }
            }
        }
    }
}

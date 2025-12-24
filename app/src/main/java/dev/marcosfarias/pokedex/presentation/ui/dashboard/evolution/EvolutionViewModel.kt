package dev.marcosfarias.pokedex.presentation.ui.dashboard.evolution

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.marcosfarias.pokedex.domain.entity.Result
import dev.marcosfarias.pokedex.domain.use_case.GetPokemonEvolutionsUseCase
import dev.marcosfarias.pokedex.presentation.model.UIPokemonItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EvolutionViewModel(
    private val getPokemonEvolutionsUseCase: GetPokemonEvolutionsUseCase
) : ViewModel() {

    private val _evolutions = MutableStateFlow<List<UIPokemonItem>>(listOf())
    val evolutions: StateFlow<List<UIPokemonItem>>
        get() = _evolutions.asStateFlow()

    fun getPokemonEvolution(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getPokemonEvolutionsUseCase(id).collect { result ->
                when (result) {
                    is Result.Success -> {
                        val evolutionList = mutableListOf<UIPokemonItem>()
                        result.data?.forEach {
                            evolutionList.add(
                                UIPokemonItem(
                                    id = it.id,
                                    name = it.name,
                                    typeOfPokemon = it.typeOfPokemon,
                                    imageUrl = it.imageUrl
                                )
                            )
                        }
                        _evolutions.emit(evolutionList)
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
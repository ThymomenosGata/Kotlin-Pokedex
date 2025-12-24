package dev.marcosfarias.pokedex.presentation.ui.dashboard.about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.marcosfarias.pokedex.domain.entity.Result
import dev.marcosfarias.pokedex.domain.use_case.GetPokemonByIdUseCase
import dev.marcosfarias.pokedex.presentation.model.UIAboutState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AboutViewModel(
    private val getPokemonByIdUseCase: GetPokemonByIdUseCase
) : ViewModel() {

    private val _uiPokemonState = MutableStateFlow<UIAboutState?>(null)
    val uiPokemonState: StateFlow<UIAboutState?>
        get() = _uiPokemonState.asStateFlow()

    fun loadPokemonInfo(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getPokemonByIdUseCase(id).collect { result ->
                when (result) {
                    is Result.Success -> {
                        result.data?.let { pokemon ->
                            _uiPokemonState.emit(
                                UIAboutState(
                                    xDescription = pokemon.xDescription,
                                    height = pokemon.height,
                                    weight = pokemon.weight,
                                    cycles = pokemon.cycles,
                                    eggGroups = pokemon.eggGroups,
                                    baseExp = pokemon.baseExp
                                )
                            )
                        }
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
package dev.marcosfarias.pokedex.presentation.ui.dashboard.stats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.marcosfarias.pokedex.domain.entity.Result
import dev.marcosfarias.pokedex.domain.use_case.GetPokemonByIdUseCase
import dev.marcosfarias.pokedex.presentation.model.UIStatsState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StatsViewModel(
    private val getPokemonByIdUseCase: GetPokemonByIdUseCase
) : ViewModel() {

    private val _statsState = MutableStateFlow<UIStatsState?>(null)
    val statsState: StateFlow<UIStatsState?>
        get() = _statsState.asStateFlow()

    fun getStats(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getPokemonByIdUseCase(id).collect { result ->
                when (result) {
                    is Result.Success -> {
                        result.data?.let {
                            _statsState.emit(
                                UIStatsState(
                                    yDescription = it.yDescription,
                                    hp = it.hp,
                                    attack = it.attack,
                                    defense = it.defense,
                                    specialAttack = it.specialAttack,
                                    specialDefense = it.specialDefense,
                                    speed = it.speed,
                                    total = it.total
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
package dev.marcosfarias.pokedex.presentation.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.marcosfarias.pokedex.domain.entity.Result
import dev.marcosfarias.pokedex.domain.use_case.GetPokemonByIdUseCase
import dev.marcosfarias.pokedex.presentation.model.UIPokemonItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val getPokemonByIdUseCase: GetPokemonByIdUseCase
) : ViewModel() {

    private val _dashboardState = MutableStateFlow<UIPokemonItem?>(null)
    val dashboardState: StateFlow<UIPokemonItem?>
        get() = _dashboardState.asStateFlow()

    fun getPokemonById(id: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getPokemonByIdUseCase(id).collect { result ->
                when (result) {
                    is Result.Success -> {
                        result.data?.let {
                            _dashboardState.emit(
                                UIPokemonItem(
                                    id = it.id,
                                    name = it.name,
                                    typeOfPokemon = it.typeOfPokemon,
                                    imageUrl = it.imageUrl
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

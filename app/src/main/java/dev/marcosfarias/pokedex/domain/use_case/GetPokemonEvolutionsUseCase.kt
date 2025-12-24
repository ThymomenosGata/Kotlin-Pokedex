package dev.marcosfarias.pokedex.domain.use_case

import dev.marcosfarias.pokedex.domain.entity.AppState
import dev.marcosfarias.pokedex.domain.entity.Pokemon
import dev.marcosfarias.pokedex.domain.entity.Result
import dev.marcosfarias.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.flow

class GetPokemonEvolutionsUseCase(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(id: String) = flow<Result<List<Pokemon>>> {
        emit(Result.State(AppState.Loading))
        pokemonRepository.getLocalPokemonById(id).let { result ->
            when (result) {
                is Result.Success -> {
                    emit(
                        pokemonRepository.getLocalEvolutionsById(
                            result.data?.evolutions ?: listOf()
                        )
                    )
                }
                is Result.State -> {
                    emit(result)
                }

                is Result.Failure -> {
                    emit(result)
                }
            }
        }
    }

}
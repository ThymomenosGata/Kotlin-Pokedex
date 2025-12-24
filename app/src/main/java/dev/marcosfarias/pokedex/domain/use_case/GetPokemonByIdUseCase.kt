package dev.marcosfarias.pokedex.domain.use_case

import dev.marcosfarias.pokedex.domain.entity.AppState
import dev.marcosfarias.pokedex.domain.entity.Pokemon
import dev.marcosfarias.pokedex.domain.entity.Result
import dev.marcosfarias.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.flow

class GetPokemonByIdUseCase(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(id: String) = flow<Result<Pokemon>> {
        val result = pokemonRepository.getLocalPokemonById(id)

        if (result is Result.Success && result.data != null) {
            emit(result)
        }

        emit(Result.Failure(AppState.NotFound))
    }

}
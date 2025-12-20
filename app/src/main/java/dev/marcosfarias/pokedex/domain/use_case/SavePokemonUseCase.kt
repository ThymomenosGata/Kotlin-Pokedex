package dev.marcosfarias.pokedex.domain.use_case

import dev.marcosfarias.pokedex.domain.entity.AppError
import dev.marcosfarias.pokedex.domain.entity.Pokemon
import dev.marcosfarias.pokedex.domain.entity.Result
import dev.marcosfarias.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.flow

class SavePokemonUseCase(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(pokemon: Pokemon) = flow<Result<Any>> {
        runCatching {
            pokemonRepository.addPokemon(pokemon)
            emit(Result.Success(Any()))
        }.onFailure {
            emit(Result.Error(AppError.Unknown(it.message ?: UNKNOWN_ERROR)))
        }
    }

    private companion object {
        const val UNKNOWN_ERROR = "Error"
    }

}
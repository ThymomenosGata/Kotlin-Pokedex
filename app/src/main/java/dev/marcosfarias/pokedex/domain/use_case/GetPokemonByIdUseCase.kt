package dev.marcosfarias.pokedex.domain.use_case

import dev.marcosfarias.pokedex.domain.entity.AppError
import dev.marcosfarias.pokedex.domain.entity.Pokemon
import dev.marcosfarias.pokedex.domain.entity.Result
import dev.marcosfarias.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.flow

class GetPokemonByIdUseCase(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(id: String) = flow<Result<Pokemon>> {
        runCatching {
            val pokemon = pokemonRepository.getLocalPokemonById(id)
            if (pokemon == null) emit(Result.Error(AppError.NotFound))
            else emit(Result.Success(pokemon))
        }.onFailure { ex ->
            emit(Result.Error(AppError.Unknown(ex.message ?: UNKNOWN_ERROR)))
        }
    }

    private companion object {
        const val UNKNOWN_ERROR = "Error"
    }

}
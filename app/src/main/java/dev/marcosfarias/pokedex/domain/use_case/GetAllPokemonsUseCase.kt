package dev.marcosfarias.pokedex.domain.use_case

import dev.marcosfarias.pokedex.domain.entity.AppState
import dev.marcosfarias.pokedex.domain.entity.Pokemon
import dev.marcosfarias.pokedex.domain.entity.Result
import dev.marcosfarias.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.flow

class GetAllPokemonsUseCase(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke() = flow<Result<List<Pokemon>>> {
        emit(Result.State(AppState.Loading))
        val localResult = pokemonRepository.getAllLocalPokemon()

        if (localResult is Result.Failure) {
            emit(localResult)
        }

        val isSuccessAndNull = localResult is Result.Success && localResult.data == null
        val isSuccessAndNotNull = localResult is Result.Success && localResult.data != null

        if (isSuccessAndNull || isSuccessAndNotNull && localResult.data.isEmpty()) {
            emit(Result.Failure(AppState.Empty))
        }

        if (isSuccessAndNotNull && localResult.data.isNotEmpty()) {
            emit(localResult)
        }

        val remoteResult = pokemonRepository.getAllRemotePokemon()

        if (remoteResult is Result.Success) {
            remoteResult.data?.let { pokemonList ->
                pokemonRepository.addMoreThenOnePokemon(pokemonList)
            }
        }
        emit(remoteResult)
    }
}
package dev.marcosfarias.pokedex.data.repository

import dev.marcosfarias.pokedex.data.extention.safeApiCall
import dev.marcosfarias.pokedex.data.extention.safeDbCall
import dev.marcosfarias.pokedex.data.extention.toResult
import dev.marcosfarias.pokedex.data.local.AppDatabase
import dev.marcosfarias.pokedex.data.mapper.toPokemonDomain
import dev.marcosfarias.pokedex.data.mapper.toPokemonEntity
import dev.marcosfarias.pokedex.data.remote.api.PokemonDexApi
import dev.marcosfarias.pokedex.domain.entity.Pokemon
import dev.marcosfarias.pokedex.domain.entity.Result
import dev.marcosfarias.pokedex.domain.repository.PokemonRepository

class PokemonRepositoryImpl(
    private val pokemonDexApi: PokemonDexApi,
    private val appDatabase: AppDatabase,
) : PokemonRepository {

    override suspend fun getAllLocalPokemon(): Result<List<Pokemon>> = safeDbCall {
        appDatabase.pokemonDAO().all().toPokemonDomain()
    }

    override suspend fun getAllRemotePokemon(): Result<List<Pokemon>> = safeApiCall {
        pokemonDexApi.getAllPokemon().toResult { dto ->
            dto.toPokemonDomain()
        }
    }

    override suspend fun getLocalPokemonById(id: String): Result<Pokemon> = safeDbCall {
        appDatabase.pokemonDAO().getById(id).toPokemonDomain()
    }

    override suspend fun getLocalEvolutionsById(ids: List<String>): Result<List<Pokemon>> =
        safeDbCall {
            appDatabase.pokemonDAO().getEvolutionsByIds(ids).toPokemonDomain()
        }

    override suspend fun addPokemon(pokemon: Pokemon): Result<Long> = safeDbCall {
        appDatabase.pokemonDAO().add(pokemon.toPokemonEntity())
    }

    override suspend fun addMoreThenOnePokemon(pokemons: List<Pokemon>): Result<Long> = safeDbCall {
        appDatabase.pokemonDAO().addMoreThenOnePokemon(pokemons.toPokemonEntity())
    }

    override suspend fun deleteAllPokemon(): Result<Int> = safeDbCall {
        appDatabase.pokemonDAO().deleteAll()
    }

    override suspend fun deletePokemon(pokemon: Pokemon): Result<Int> = safeDbCall {
        appDatabase.pokemonDAO().delete(pokemon.toPokemonEntity())
    }
}
package dev.marcosfarias.pokedex.domain.repository

import dev.marcosfarias.pokedex.domain.entity.Pokemon
import dev.marcosfarias.pokedex.domain.entity.Result


interface PokemonRepository {

    suspend fun getAllLocalPokemon(): Result<List<Pokemon>>

    suspend fun getAllRemotePokemon(): Result<List<Pokemon>>

    suspend fun getLocalPokemonById(id: String): Result<Pokemon>

    suspend fun getLocalEvolutionsById(ids: List<String>): Result<List<Pokemon>>

    suspend fun addPokemon(pokemon: Pokemon): Result<Long>

    suspend fun addMoreThenOnePokemon(pokemons: List<Pokemon>): Result<Any>

    suspend fun deleteAllPokemon(): Result<Int>

    suspend fun deletePokemon(pokemon: Pokemon): Result<Int>

}
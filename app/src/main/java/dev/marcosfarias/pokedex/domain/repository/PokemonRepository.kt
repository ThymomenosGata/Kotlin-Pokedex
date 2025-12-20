package dev.marcosfarias.pokedex.domain.repository

import dev.marcosfarias.pokedex.domain.entity.Pokemon


interface PokemonRepository {

    fun getAllPokemons(): List<Pokemon>

    fun getAllLocalPokemons(): List<Pokemon>

    fun getRemotePokemons(): List<Pokemon>

    fun getLocalPokemonById(id: String): Pokemon?

    fun getLocalEvolutionsById(id: String): List<Pokemon>

    fun addPokemon(pokemon: Pokemon)

    fun addMoreThenOnePokemon(pokemons: List<Pokemon>)

    fun deleteAllPokemon()

    fun deletePokemon(pokemon: Pokemon)

}
package dev.marcosfarias.pokedex.data.repository

import dev.marcosfarias.pokedex.domain.entity.Pokemon
import dev.marcosfarias.pokedex.domain.repository.PokemonRepository

class PokemonRepositoryImpl: PokemonRepository {

    override fun getAllPokemons(): List<Pokemon> {
        TODO("Not yet implemented")
    }

    override fun getAllLocalPokemons(): List<Pokemon> {
        TODO("Not yet implemented")
    }

    override fun getRemotePokemons(): List<Pokemon> {
        TODO("Not yet implemented")
    }

    override fun getLocalPokemonById(id: String): Pokemon {
        TODO("Not yet implemented")
    }

    override fun getLocalEvolutionsById(id: String): List<Pokemon> {
        TODO("Not yet implemented")
    }

    override fun addPokemon(pokemon: Pokemon) {
        TODO("Not yet implemented")
    }

    override fun addMoreThenOnePokemon(pokemons: List<Pokemon>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllPokemon() {
        TODO("Not yet implemented")
    }

    override fun deletePokemon(pokemon: Pokemon) {
        TODO("Not yet implemented")
    }

}
package dev.marcosfarias.pokedex.data.remote.api

import dev.marcosfarias.pokedex.data.remote.dto.PokemonDto
import retrofit2.Response
import retrofit2.http.GET

interface PokemonDexApi {

    @GET("pokemon.json")
    suspend fun getAllPokemon(): Response<List<PokemonDto>>

}
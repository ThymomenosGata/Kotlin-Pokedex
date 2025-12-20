package dev.marcosfarias.pokedex.data.remote.api

import dev.marcosfarias.pokedex.data.remote.dto.PokemonDto
import retrofit2.Response
import retrofit2.http.GET

interface PokemonDexApi {

    @GET("/mrcsxsiq/b94dbe9ab67147b642baa9109ce16e44/raw/97811a5df2df7304b5bc4fbb9ee018a0339b8a38/pokemon.json")
    suspend fun getAllPokemon(): Response<List<PokemonDto>>

}
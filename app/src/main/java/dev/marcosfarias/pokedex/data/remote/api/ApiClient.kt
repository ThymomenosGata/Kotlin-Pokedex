package dev.marcosfarias.pokedex.data.remote.api

import dev.marcosfarias.pokedex.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object {
        private val pokemonDexApi: PokemonDexApi? = null

        fun getApi(): PokemonDexApi {
            if (pokemonDexApi != null) return pokemonDexApi
            return create()
        }

        private fun create(): PokemonDexApi {
            val client = OkHttpClient.Builder()

            return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonDexApi::class.java)
        }
    }
}
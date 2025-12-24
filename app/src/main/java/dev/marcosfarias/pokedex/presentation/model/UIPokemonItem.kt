package dev.marcosfarias.pokedex.presentation.model

data class UIPokemonItem(
    val id: String,
    val name: String,
    val typeOfPokemon: List<String>,
    val imageUrl: String
)

package dev.marcosfarias.pokedex.domain.entity

sealed class AppState {

    object NoInternet : AppState()

    object ServerNotAvailable : AppState()

    object Unauthorized : AppState()

    object NotFound : AppState()

    object Empty : AppState()

    object Loading : AppState()

    data class Unknown(val message: String, val code: Int) : AppState()

}
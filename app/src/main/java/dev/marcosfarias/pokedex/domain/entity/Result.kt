package dev.marcosfarias.pokedex.domain.entity

sealed class Result<out T> {

    data class Success<out T>(val data: T?) : Result<T>()

    data class Failure(val error: AppState) : Result<Nothing>()

    data class State(val state: AppState) : Result<Nothing>()
}
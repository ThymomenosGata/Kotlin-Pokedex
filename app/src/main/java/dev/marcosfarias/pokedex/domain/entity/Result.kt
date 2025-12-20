package dev.marcosfarias.pokedex.domain.entity

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()

    data class Error(val error: AppError) : Result<Nothing>()

}
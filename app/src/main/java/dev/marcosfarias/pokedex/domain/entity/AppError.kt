package dev.marcosfarias.pokedex.domain.entity

sealed class AppError {

    object NoInternet : AppError()

    object ServerNotAvailable : AppError()

    object Unauthorized : AppError()

    object NotFound : AppError()

    data class Unknown(val message: String, val code: Int) : AppError()

}
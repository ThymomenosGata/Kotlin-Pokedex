package dev.marcosfarias.pokedex.domain.entity

sealed class AppError {

    object NoInternet: AppError()

    object ServerNotAvailable: AppError()

    object NotFound : AppError()

    data class Unknown(val message: String) : AppError()

}
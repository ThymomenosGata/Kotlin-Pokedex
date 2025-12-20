package dev.marcosfarias.pokedex.data.extention

import dev.marcosfarias.pokedex.domain.entity.AppError
import dev.marcosfarias.pokedex.domain.entity.Result
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException

internal suspend fun <T> safeApiCall(call: suspend () -> Result<T>): Result<T> {
    return withContext(Dispatchers.IO) {
        try {
            call()
        } catch (ex: Exception) {
            when (ex) {
                is CancellationException -> throw ex

                is IOException -> Result.Error(AppError.NoInternet)

                else -> Result.Error(AppError.Unknown(ex.message ?: "Unknown Error", -1))
            }
        }
    }
}

internal suspend fun <T> safeDbCall(call: suspend () -> T): Result<T> {
    return withContext(Dispatchers.IO) {
        try {
            Result.Success(call())
        } catch (ex: Exception) {
            when (ex) {
                is CancellationException -> throw ex

                else -> Result.Error(AppError.Unknown(ex.message ?: "Unknown Error", -1))
            }
        }
    }
}
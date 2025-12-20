package dev.marcosfarias.pokedex.data.extention

import dev.marcosfarias.pokedex.domain.entity.AppError
import dev.marcosfarias.pokedex.domain.entity.Result
import retrofit2.Response

internal fun <T, R> Response<T>.toResult(mapper: (T) -> R): Result<R> {
    if (!this.isSuccessful) {
        val error = when (this.code()) {
            401 -> AppError.Unauthorized
            404 -> AppError.NotFound
            else -> AppError.Unknown(
                message = this.message(),
                code = this.code()
            )
        }
        return Result.Error(error)
    }
    return body()?.let {
        Result.Success(mapper(it))
    } ?: Result.Error(AppError.Unknown("Body is null", -1))
}
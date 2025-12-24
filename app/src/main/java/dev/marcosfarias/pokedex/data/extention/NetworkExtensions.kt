package dev.marcosfarias.pokedex.data.extention

import dev.marcosfarias.pokedex.domain.entity.AppState
import dev.marcosfarias.pokedex.domain.entity.Result
import retrofit2.Response

internal fun <T, R> Response<T>.toResult(mapper: (T) -> R): Result<R> {
    if (!this.isSuccessful) {
        val error = when (this.code()) {
            401 -> AppState.Unauthorized
            404 -> AppState.NotFound
            in 500..599 -> AppState.ServerNotAvailable
            else -> AppState.Unknown(
                message = this.message(),
                code = this.code()
            )
        }
        return Result.Failure(error)
    }
    return body()?.let {
        Result.Success(mapper(it))
    } ?: Result.Failure(AppState.Unknown("Body is null", -1))
}
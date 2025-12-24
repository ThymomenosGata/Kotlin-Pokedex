package dev.marcosfarias.pokedex.data.extention

fun Int?.orZero(): Int = this ?: 0

fun <T> List<T>?.orEmptyList(): List<T> = this ?: listOf<T>()
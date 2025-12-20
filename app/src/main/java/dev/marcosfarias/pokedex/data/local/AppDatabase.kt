package dev.marcosfarias.pokedex.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.marcosfarias.pokedex.data.local.dao.PokemonDAO
import dev.marcosfarias.pokedex.model.Pokemon

@Database(entities = [Pokemon::class], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDAO(): PokemonDAO

}

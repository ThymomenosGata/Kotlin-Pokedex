package dev.marcosfarias.pokedex.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.marcosfarias.pokedex.data.local.AppDatabase.Companion.CURRENT_DB_VERSION
import dev.marcosfarias.pokedex.data.local.dao.PokemonDAO
import dev.marcosfarias.pokedex.data.local.entity.PokemonEntity

@Database(
    entities = [
        PokemonEntity::class
    ],
    version = CURRENT_DB_VERSION,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDAO(): PokemonDAO

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private const val CURRENT_DB_VERSION = 1
        private const val CURRENT_DB_NAME = "Pokedex.db"


        fun getInstance(
            context: Context
        ) = instance ?: synchronized(this) {
            instance ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            CURRENT_DB_NAME
        ).build()
    }
}

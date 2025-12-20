package dev.marcosfarias.pokedex.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.marcosfarias.pokedex.data.local.entity.PokemonEntity

@Dao
interface PokemonDAO {

    @Query("SELECT * FROM pokemon WHERE id = :id")
    fun getById(id: String?): PokemonEntity

    @Query("SELECT * FROM pokemon WHERE id IN(:evolutionIds)")
    fun getEvolutionsByIds(evolutionIds: List<String>): List<PokemonEntity>

    @Query("SELECT * FROM pokemon")
    fun all(): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(pokemon: PokemonEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMoreThenOnePokemon(pokemon: List<PokemonEntity>): Long

    @Query("DELETE FROM pokemon")
    fun deleteAll(): Int

    @Delete
    fun delete(model: PokemonEntity): Int
}

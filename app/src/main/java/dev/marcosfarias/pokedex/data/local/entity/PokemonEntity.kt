package dev.marcosfarias.pokedex.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import dev.marcosfarias.pokedex.utils.ListStringConverter

@Entity(tableName = "Pokemon")
@TypeConverters(ListStringConverter::class)
data class PokemonEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "abilities")
    val abilities: List<String>,
    @ColumnInfo(name = "attack")
    val attack: Int,
    @ColumnInfo(name = "base_exp")
    val baseExp: String,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "cycles")
    val cycles: String,
    @ColumnInfo(name = "defense")
    val defense: Int,
    @ColumnInfo(name = "egg_groups")
    val eggGroups: String,
    @ColumnInfo(name = "evolutions")
    val evolutions: List<String>,
    @ColumnInfo(name = "evolved_from")
    val evolvedFrom: String,
    @ColumnInfo(name = "female_percentage")
    val femalePercentage: String,
    @ColumnInfo(name = "genderless")
    val genderless: Int,
    @ColumnInfo(name = "height")
    val height: String,
    @ColumnInfo(name = "hp")
    val hp: Int,
    @ColumnInfo(name = "image_url")
    val imageUrl: String,
    @ColumnInfo(name = "male_percentage")
    val malePercentage: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "reason")
    val reason: String,
    @ColumnInfo(name = "special_attack")
    val specialAttack: Int,
    @ColumnInfo(name = "special_defense")
    val specialDefense: Int,
    @ColumnInfo(name = "speed")
    val speed: Int,
    @ColumnInfo(name = "total")
    val total: Int,
    @ColumnInfo(name = "type_of_pokemon")
    val typeOfPokemon: List<String>,
    @ColumnInfo(name = "weaknesses")
    val weaknesses: List<String>,
    @ColumnInfo(name = "weight")
    val weight: String,
    @ColumnInfo(name = "x_description")
    val xDescription: String,
    @ColumnInfo(name = "y_description")
    val yDescription: String
)
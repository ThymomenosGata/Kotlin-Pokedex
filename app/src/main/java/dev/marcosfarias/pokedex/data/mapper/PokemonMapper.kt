package dev.marcosfarias.pokedex.data.mapper

import dev.marcosfarias.pokedex.data.extention.orEmptyList
import dev.marcosfarias.pokedex.data.extention.orZero
import dev.marcosfarias.pokedex.data.local.entity.PokemonEntity
import dev.marcosfarias.pokedex.data.remote.dto.PokemonDto
import dev.marcosfarias.pokedex.domain.entity.Pokemon

internal fun PokemonEntity.toPokemonDto() = PokemonDto(
    id = id,
    abilities = abilities,
    attack = attack,
    baseExp = baseExp,
    category = category,
    cycles = cycles,
    defense = defense,
    eggGroups = eggGroups,
    evolutions = evolutions,
    evolvedFrom = evolvedFrom,
    femalePercentage = femalePercentage,
    genderless = genderless,
    height = height,
    hp = hp,
    imageUrl = imageUrl,
    malePercentage = malePercentage,
    name = name,
    reason = reason,
    specialAttack = specialAttack,
    specialDefense = specialDefense,
    speed = speed,
    total = total,
    typeOfPokemon = typeOfPokemon,
    weaknesses = weaknesses,
    weight = weight,
    xDescription = xDescription,
    yDescription = yDescription,
)

internal fun PokemonEntity.toPokemonDomain() = Pokemon(
    id = id,
    abilities = abilities,
    attack = attack,
    baseExp = baseExp,
    category = category,
    cycles = cycles,
    defense = defense,
    eggGroups = eggGroups,
    evolutions = evolutions,
    evolvedFrom = evolvedFrom,
    femalePercentage = femalePercentage,
    genderless = genderless,
    height = height,
    hp = hp,
    imageUrl = imageUrl,
    malePercentage = malePercentage,
    name = name,
    reason = reason,
    specialAttack = specialAttack,
    specialDefense = specialDefense,
    speed = speed,
    total = total,
    typeOfPokemon = typeOfPokemon,
    weaknesses = weaknesses,
    weight = weight,
    xDescription = xDescription,
    yDescription = yDescription
)

internal fun PokemonDto.toPokemonEntity() = PokemonEntity(
    id = id.orEmpty(),
    abilities = abilities.orEmptyList(),
    attack = attack.orZero(),
    baseExp = baseExp.orEmpty(),
    category = category.orEmpty(),
    cycles = cycles.orEmpty(),
    defense = defense.orZero(),
    eggGroups = eggGroups.orEmpty(),
    evolutions = evolutions.orEmpty(),
    evolvedFrom = evolvedFrom.orEmpty(),
    femalePercentage = femalePercentage.orEmpty(),
    genderless = genderless.orZero(),
    height = height.orEmpty(),
    hp = hp.orZero(),
    imageUrl = imageUrl.orEmpty(),
    malePercentage = malePercentage.orEmpty(),
    name = name.orEmpty(),
    reason = reason.orEmpty(),
    specialAttack = specialAttack.orZero(),
    specialDefense = specialDefense.orZero(),
    speed = speed.orZero(),
    total = total.orZero(),
    typeOfPokemon = typeOfPokemon.orEmptyList(),
    weaknesses = weaknesses.orEmptyList(),
    weight = weight.orEmpty(),
    xDescription = xDescription.orEmpty(),
    yDescription = yDescription.orEmpty()
)

internal fun PokemonDto.toPokemonDomain() = Pokemon(
    id = id.orEmpty(),
    abilities = abilities.orEmptyList(),
    attack = attack.orZero(),
    baseExp = baseExp.orEmpty(),
    category = category.orEmpty(),
    cycles = cycles.orEmpty(),
    defense = defense.orZero(),
    eggGroups = eggGroups.orEmpty(),
    evolutions = evolutions.orEmpty(),
    evolvedFrom = evolvedFrom.orEmpty(),
    femalePercentage = femalePercentage.orEmpty(),
    genderless = genderless.orZero(),
    height = height.orEmpty(),
    hp = hp.orZero(),
    imageUrl = imageUrl.orEmpty(),
    malePercentage = malePercentage.orEmpty(),
    name = name.orEmpty(),
    reason = reason.orEmpty(),
    specialAttack = specialAttack.orZero(),
    specialDefense = specialDefense.orZero(),
    speed = speed.orZero(),
    total = total.orZero(),
    typeOfPokemon = typeOfPokemon.orEmptyList(),
    weaknesses = weaknesses.orEmptyList(),
    weight = weight.orEmpty(),
    xDescription = xDescription.orEmpty(),
    yDescription = yDescription.orEmpty()
)

internal fun Pokemon.toPokemonEntity() = PokemonEntity(
    id = id,
    abilities = abilities,
    attack = attack,
    baseExp = baseExp,
    category = category,
    cycles = cycles,
    defense = defense,
    eggGroups = eggGroups,
    evolutions = evolutions,
    evolvedFrom = evolvedFrom,
    femalePercentage = femalePercentage,
    genderless = genderless,
    height = height,
    hp = hp,
    imageUrl = imageUrl,
    malePercentage = malePercentage,
    name = name,
    reason = reason,
    specialAttack = specialAttack,
    specialDefense = specialDefense,
    speed = speed,
    total = total,
    typeOfPokemon = typeOfPokemon,
    weaknesses = weaknesses,
    weight = weight,
    xDescription = xDescription,
    yDescription = yDescription
)

internal fun Pokemon.toPokemonDto() = PokemonDto(
    id = id,
    abilities = abilities,
    attack = attack,
    baseExp = baseExp,
    category = category,
    cycles = cycles,
    defense = defense,
    eggGroups = eggGroups,
    evolutions = evolutions,
    evolvedFrom = evolvedFrom,
    femalePercentage = femalePercentage,
    genderless = genderless,
    height = height,
    hp = hp,
    imageUrl = imageUrl,
    malePercentage = malePercentage,
    name = name,
    reason = reason,
    specialAttack = specialAttack,
    specialDefense = specialDefense,
    speed = speed,
    total = total,
    typeOfPokemon = typeOfPokemon,
    weaknesses = weaknesses,
    weight = weight,
    xDescription = xDescription,
    yDescription = yDescription
)

@JvmName("toPokemonDomainFromEntityList")
internal fun List<PokemonEntity>.toPokemonDomain(): List<Pokemon> = map {
    it.toPokemonDomain()
}.toList()

@JvmName("toPokemonDtoFromEntityList")
internal fun List<PokemonEntity>.toPokemonDto(): List<PokemonDto> = map {
    it.toPokemonDto()
}.toList()

@JvmName("toPokemonEntityFromDomainList")
internal fun List<Pokemon>.toPokemonEntity(): List<PokemonEntity> = map {
    it.toPokemonEntity()
}.toList()

@JvmName("toPokemonDtoFromDomainList")
internal fun List<Pokemon>.toPokemonDto(): List<PokemonDto> = map {
    it.toPokemonDto()
}.toList()

@JvmName("toPokemonEntityFromEntityList")
internal fun List<PokemonDto>.toPokemonEntity(): List<PokemonEntity> = map {
    it.toPokemonEntity()
}.toList()

@JvmName("toPokemonDomainFromDtoList")
internal fun List<PokemonDto>.toPokemonDomain(): List<Pokemon> = map {
    it.toPokemonDomain()
}.toList()
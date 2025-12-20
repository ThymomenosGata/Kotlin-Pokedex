package dev.marcosfarias.pokedex.data.mapper

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

internal fun PokemonDto.toPokemonDomain() = Pokemon(
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

internal fun List<PokemonEntity>.toPokemonDomain() = this.map {
    it.toPokemonDomain()
}

internal fun List<PokemonEntity>.toPokemonDto() = this.map {
    it.toPokemonDto()
}

internal fun List<Pokemon>.toPokemonEntity() = this.map {
    it.toPokemonEntity()
}

internal fun List<Pokemon>.toPokemonDto() = this.map {
    it.toPokemonDto()
}

internal fun List<PokemonDto>.toPokemonEntity() = this.map {
    it.toPokemonEntity()
}

internal fun List<PokemonDto>.toPokemonDomain() = this.map {
    it.toPokemonDomain()
}
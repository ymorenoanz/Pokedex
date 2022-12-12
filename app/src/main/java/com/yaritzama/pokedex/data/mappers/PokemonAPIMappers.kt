package com.yaritzama.pokedex.data.mappers

import com.yaritzama.pokedex.data.models.PokemonResponse
import com.yaritzama.pokedex.data.models.ResultPokemon
import com.yaritzama.pokedex.domain.models.Pokemon
import com.yaritzama.pokedex.domain.models.PokemonList

fun PokemonResponse.toDomain() : Pokemon{
    return Pokemon(
        name = this.name,
        height = this.height,
        weight = this.weight)
}

fun ResultPokemon.toDomain() : Pokemon {
    return Pokemon(
        name = this.name,
        url = this.url
    )
}
package com.yaritzama.pokedex.data.models

data class PokemonResponse(
    val id: Int?,
    val name: String?,
    val height: Int? = 0,
    val weight: Int? = 0,
    val baseExperience: Int = 0,
    val order: Int = 0,
)
package com.yaritzama.pokedex.domain.models

data class Pokemon(
    val name: String? = "",
    val url: String? = "",
    val height: Int? = 0,
    val weight: Int? = 0,
    val baseExperience: Int = 0,
    val order: Int = 0,
    val image: String= ""
)

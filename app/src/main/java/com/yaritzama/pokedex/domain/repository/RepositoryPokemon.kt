package com.yaritzama.pokedex.domain.repository

import com.yaritzama.pokedex.domain.models.Pokemon

interface RepositoryPokemon {
    suspend fun getPokemon(): List<Pokemon>
    suspend fun getPokemonById(name: String): Pokemon
}
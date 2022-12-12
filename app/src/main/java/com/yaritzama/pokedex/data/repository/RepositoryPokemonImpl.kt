package com.yaritzama.pokedex.data.repository

import com.yaritzama.pokedex.data.api.PokemonAPI
import com.yaritzama.pokedex.data.mappers.toDomain
import com.yaritzama.pokedex.domain.models.Pokemon
import com.yaritzama.pokedex.domain.repository.RepositoryPokemon
import javax.inject.Inject

class RepositoryPokemonImpl @Inject constructor(
    private val api: PokemonAPI) : RepositoryPokemon {
    override suspend fun getPokemon(): List<Pokemon> {
        val result = api.getPokemonList(100, 0)
        return result.body()?.resultPokemons?.map{
            it?.toDomain() ?: Pokemon()
        } ?: listOf()
    }


    override suspend fun getPokemonById(name: String): Pokemon {
        val response = api.getPokemonById(name)
       return response.body()?.toDomain() ?: throw Exception("Network error")
    }
}
package com.yaritzama.pokedex.data.api

import com.yaritzama.pokedex.data.models.PokemonListResponse
import com.yaritzama.pokedex.data.models.PokemonResponse
import com.yaritzama.pokedex.data.models.ResultPokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonAPI {
    @GET("pokemon/{name}")
    suspend fun getPokemonById(@Path("name") name: String): Response<PokemonResponse>

    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int,
                               @Query("offset") offset: Int): Response<PokemonListResponse>
}
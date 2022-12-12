package com.yaritzama.pokedex.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yaritzama.pokedex.domain.models.Pokemon
import com.yaritzama.pokedex.domain.repository.RepositoryPokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val repo: RepositoryPokemon
) : ViewModel() {

    private val _pokemonListState = mutableStateListOf<Pokemon>()
    val pokemonListState: SnapshotStateList<Pokemon>
        get() = _pokemonListState

    var pokemonList = mutableStateOf<List<Pokemon>>(listOf())
    var cachedPokemon = listOf<Pokemon>()
    var isSearchStarting = true
    var isSearching = mutableStateOf(false)

    init{
        getPokemonByName()
    }

    fun searchPokemon(query: String){
        
    }

    private fun getPokemonByName(){
        viewModelScope.launch(Dispatchers.IO) {
            val pokemon = repo.getPokemon()
            _pokemonListState.addAll(pokemon)
        }
    }

    private fun getPokemonById() {
        viewModelScope.launch(Dispatchers.IO) {
            val pokemon = repo.getPokemon()
           val pokedexEntries = pokemon.mapIndexed { index, pokemon ->
                val number = if(pokemon.url?.endsWith("/")!!){
                    pokemon.url.dropLast(1).takeLastWhile { it.isDigit() }
                } else {
                    pokemon.url.takeLastWhile { it.isDigit() }
                }
                val url =  "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" +
                        "${number}.png"

                Pokemon(pokemon.name?.capitalize(Locale.ROOT), url, number.toInt())
            }
            pokemonList.value += pokedexEntries
        }

    }
}
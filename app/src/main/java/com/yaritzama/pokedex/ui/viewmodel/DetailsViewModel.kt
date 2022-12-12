package com.yaritzama.pokedex.ui.viewmodel

import androidx.compose.runtime.State
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
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repo:RepositoryPokemon
) : ViewModel() {

    private val _details = mutableStateOf("")
    val details: State<String>
    get() = _details

    init{
        viewModelScope.launch(Dispatchers.IO)  {
            val pokemon = repo.getPokemonById("")
            _details.value = pokemon.name.toString()
            //_details.value = pokemon.id ?: 0
        }
    }

    fun getDetails(id: Int){}

}
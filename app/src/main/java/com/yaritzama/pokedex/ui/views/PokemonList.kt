package com.yaritzama.pokedex.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.skydoves.landscapist.glide.GlideImage
import com.yaritzama.pokedex.R
import com.yaritzama.pokedex.ui.viewmodel.DetailsViewModel
import com.yaritzama.pokedex.ui.viewmodel.PokemonViewModel

@Composable
fun PokemonList(){
    val vm: PokemonViewModel = hiltViewModel()
    /*val pokemonList = vm.pokemonList
    items(pokemonList.value) */
    val pokemon = vm.pokemonListState

    Column(modifier = Modifier.padding(8.dp)) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(pokemon) { item->
                    Card(elevation = 8.dp, modifier =
                    Modifier.padding(8.dp)){
                        Column(
                            Modifier.padding(16.dp)) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = item.name.toString(),
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Left
                            )
                            Box(modifier = Modifier
                                .height(100.dp)
                                .width(100.dp)){
                                GlideImage(imageModel = {"https://img.pokemondb.net/artwork/large/" +
                                        "${item.name}.jpg"})
                            }

                            Button(onClick = { /*TODO*/ }) {
                                Text(text = "Details")
                            }
                        }
                    }
                }
            })
    }
}

@Composable
fun SearchBar(modifier: Modifier,
              onSearch: (String) -> Unit = {}){

    var text by remember { mutableStateOf("") }
}

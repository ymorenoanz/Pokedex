package com.yaritzama.pokedex.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.skydoves.landscapist.glide.GlideImage
import com.yaritzama.pokedex.ui.viewmodel.PokemonViewModel
import com.yaritzama.pokedex.ui.theme.PokedexTheme
import com.yaritzama.pokedex.ui.viewmodel.DetailsViewModel
import com.yaritzama.pokedex.ui.views.PokemonDetails
import com.yaritzama.pokedex.ui.views.PokemonList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val vm: PokemonViewModel = hiltViewModel()
                    val vmDetail : DetailsViewModel = hiltViewModel()
                    val navController = rememberNavController()

                    PokemonList()
                }
            }
        }
    }
}

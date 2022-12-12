package com.yaritzama.pokedex.di

import com.yaritzama.pokedex.data.repository.RepositoryPokemonImpl
import com.yaritzama.pokedex.domain.repository.RepositoryPokemon
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun providePokemonRepository(
        impl: RepositoryPokemonImpl): RepositoryPokemon
}
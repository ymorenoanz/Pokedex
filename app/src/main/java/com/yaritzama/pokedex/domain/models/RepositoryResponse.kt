package com.yaritzama.pokedex.domain.models

sealed class RepositoryResponse<T>{
    data class Success<T>(val data: T): RepositoryResponse<T>()
    data class Failed<T>(val errorMessage: String): RepositoryResponse<T>()
}

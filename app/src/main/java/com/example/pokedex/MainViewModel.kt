package com.example.pokedex

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel :ViewModel(){
    var pokemonListResponse:List<Pokemon> by mutableStateOf(listOf())
    fun getPokemon(){
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val pokemonList = apiService.getPokemon()
                pokemonListResponse = pokemonList.pokemon
            }catch (e:Exception){
                println (e)
            }
        }
    }

}
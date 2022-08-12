package com.example.pokedex

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
  @GET("pokedex.json")
    suspend fun getPokemon():Pokehub
    companion object{

    var apiService:ApiService? = null
      fun getInstance():ApiService{
        if (apiService == null){
          apiService = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Biuni/PokemonGo-Pokedex/master/")
            .addConverterFactory(GsonConverterFactory.create()).
            build().create(ApiService::class.java)
        }
        return apiService!!

      }      }
}
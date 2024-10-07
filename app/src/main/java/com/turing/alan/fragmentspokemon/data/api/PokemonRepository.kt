package com.turing.alan.fragmentspokemon.data.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("api/v2/pokemon/{id}/")
    suspend fun fetchPokemon(@Path("id") id:String):PokemonApiModel
}

class PokemonRepository private constructor(private val api:PokemonApi) {
    private val _pokemon = MutableLiveData<PokemonApiModel>()
    val pokemon: LiveData<PokemonApiModel> get() = _pokemon
    companion object {
        private var _INSTANCE: PokemonRepository? = null
        fun getInstance(): PokemonRepository {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GSonConverterFactory.create())
                .build()
            val pokemonApi = retrofit.create(PokemonApi::class.java)
            _INSTANCE = _INSTANCE ?: PokemonRepository(pokemonApi)
            return _INSTANCE!!
        }
    }

    suspend fun fetch(){
        val pokemonResponse = api.fetchPokemon("1")
        Log.d("Joseph",pokemonResponse.toString())
        _pokemon.value = pokemonResponse
    }
}
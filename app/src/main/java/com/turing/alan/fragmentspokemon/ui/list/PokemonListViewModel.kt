package com.turing.alan.fragmentspokemon.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.turing.alan.fragmentspokemon.data.model.Pokemon
import com.turing.alan.fragmentspokemon.data.api.PokemonApiModel
import com.turing.alan.fragmentspokemon.data.api.PokemonRepository

class PokemonListViewModel():ViewModel() {

    private val repository = PokemonRepository.getInstance()
    private  val _pokemon = MutableLiveData<Pokemon>()
    val pokemon: LiveData<Pokemon>
        get() = _pokemon
    private val observer = Observer<PokemonApiModel> {
        _pokemon.value = Pokemon(it.id, it.name)
    }
    init {
        fetch()
        val observer = Observer<PokemonApiModel>{}
        repository.pokemon.observer(activity,observer)
    }
    private fun fetch(){
        repository.pokemon.observeForever(observer)
        viewModelScope.launch{
            repository.fetch()
        }
    }

    override fun onCleared() {
        super.onCleared()
        repository.pokemon.removeObserver(observer)
    }
}
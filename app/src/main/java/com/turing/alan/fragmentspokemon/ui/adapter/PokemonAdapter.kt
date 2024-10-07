package com.turing.alan.fragmentspokemon.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.turing.alan.fragmentspokemon.data.model.Pokemon

class PokemonAdapter {private val onShowDetail:(p: Pokemon)->Unit

    ListAdapter<Pokemon, PokemonAdapter,PokemonItemViewHolder>(PokemonDiffCallback){
        inner class PokemonItemViewHolder(private val binding:PokemonItemBinding):RecyclerView.ViewHolder(){}

        override fun onCreateView
    }
}
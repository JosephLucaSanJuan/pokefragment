package com.turing.alan.fragmentspokemon.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.turing.alan.fragmentspokemon.data.model.Pokemon
import com.turing.alan.fragmentspokemon.data.api.PokemonApiModel
import com.turing.alan.fragmentspokemon.ui.list.PokemonListViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [PokemonListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PokemonListFragment : Fragment() {
    private val viewModel:PokemonListViewModel by viewModels()
    //private val viewModel:PokemonListViewModel by activityViewModels()
    private lateinit var binding: FragmentPokemonListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPokemonListBinding.inflate(inflater,
            container,
            false,
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        /*val recyclerView = binding.pokemonList
        val adapter = binding.PokemonAdapter
        adapter.submitList(repository.pokemons)
        recyclerView.adapter = adapter*/
        super.onViewCreated(view, savedInstanceState)
        /*binding.buttonNavigate.setOnclicListener {
            val action = PokemonListFragmentDirections
                .actionPokemonListFragmentToPokemonDetailFragment()
            view.findNavController().navigate(action)
        }*/
        val observer = Observer<PokemonApiModel>{
            binding.pokemonIdText.text = it.id.toString()
            binding.pokemonNameText.text = it.name.toString()
        }
        viewModel.pokemon.observe(viewLifecycleOwner,observer)
    }

    /*private fun onShowDetail(pokemon: Pokemon,view: View){
        Log.d("POKEMON","Pulsado ${pokemon.name}")
        val action = PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDirections(pokemon)
        view.findNavController().navigate(action)
    }*/
}
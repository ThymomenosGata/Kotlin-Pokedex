package dev.marcosfarias.pokedex.presentation.ui.dashboard.evolution

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.databinding.FragmentEvolutionBinding
import dev.marcosfarias.pokedex.presentation.extentions.observeWithLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel

class EvolutionFragment : Fragment() {

    private val evolutionViewModel: EvolutionViewModel by viewModel()
    private var viewBinding: FragmentEvolutionBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_evolution, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentEvolutionBinding.bind(view)

        val id = checkNotNull(arguments?.getString("id"))
        val recyclerView = viewBinding?.recyclerViewEvolvingPokemon
        val layoutManager = LinearLayoutManager(context)
        recyclerView?.layoutManager = layoutManager
        val adapter = EvolutionAdapter(view.context)
        recyclerView?.adapter = adapter

        evolutionViewModel.getPokemonEvolution(id)

        evolutionViewModel.evolutions.observeWithLifecycle(
            viewLifecycleOwner = viewLifecycleOwner,
            block = { pokemons ->
                adapter.setList(pokemons)
                adapter.notifyDataSetChanged()
                if (pokemons.isEmpty()) {
                    viewBinding?.textNonEvolving?.visibility = View.VISIBLE
                }
            }
        )
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }

    companion object {
        @JvmStatic
        fun newInstance(id: String?) = EvolutionFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }
}

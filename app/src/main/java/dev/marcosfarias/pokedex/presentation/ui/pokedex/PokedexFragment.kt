package dev.marcosfarias.pokedex.presentation.ui.pokedex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.leinardi.android.speeddial.SpeedDialView
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.databinding.FragmentPokedexBinding
import dev.marcosfarias.pokedex.presentation.extentions.navigateSafety
import dev.marcosfarias.pokedex.presentation.extentions.observeWithLifecycle
import dev.marcosfarias.pokedex.presentation.ui.generation.GenerationFragment
import dev.marcosfarias.pokedex.presentation.ui.search.SearchFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokedexFragment : Fragment() {

    private val pokedexViewModel: PokedexViewModel by viewModel()
    private var viewBinding: FragmentPokedexBinding? = null
    private var selectedPokemonId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (selectedPokemonId != null) {
            postponeEnterTransition()
        }

        return inflater.inflate(R.layout.fragment_pokedex, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        requireActivity().enableEdgeToEdge()
//        activity?.window?.statusBarColor =
//            PokemonColorUtil(view.context).convertColor(R.color.background)

        viewBinding = FragmentPokedexBinding.bind(view)

        val layoutManager = GridLayoutManager(context, 2)
        viewBinding?.recyclerView?.layoutManager = layoutManager

        pokedexViewModel.allPokemons.observeWithLifecycle(
            viewLifecycleOwner = viewLifecycleOwner,
            block = { pokemons ->
                viewBinding?.progressBar?.visibility = View.GONE
                viewBinding?.recyclerView?.visibility = View.VISIBLE
                viewBinding?.recyclerView?.adapter = PokemonAdapter(
                    list = pokemons,
                    itemClickedListener = { pokemon, viewHolder ->
                        selectedPokemonId = pokemon.id

//                        val extras = FragmentNavigatorExtras(
//                            viewHolder.itemView to viewHolder.viewBinding.imageView.transitionName
//                        )

                        val bundle = bundleOf(
                            "id" to pokemon.id,
                            "name" to pokemon.name
                        )

                        findNavController().navigateSafety(
                            actionId = R.id.action_navigation_pokedex_to_navigation_dashboard,
                            args = bundle,
//                            extras = extras
                        )
                    },
                    imageLoadedListener = { pokemon, _ ->
                        if (pokemon.id == selectedPokemonId) {
                            startPostponedEnterTransition()
                        }
                    }
                )
            }
        )

        val speedDialView = viewBinding?.speedDial
        speedDialView?.inflate(R.menu.menu_pokedex)
        speedDialView?.setOnActionSelectedListener(SpeedDialView.OnActionSelectedListener { actionItem ->
            when (actionItem.id) {
                R.id.menuAllGen -> {
                    showAllGen()
                    speedDialView.close()
                    return@OnActionSelectedListener true
                }

                R.id.menuSearch -> {
                    showSearch()
                    speedDialView.close()
                    return@OnActionSelectedListener true
                }

                else -> {
                    speedDialView.close()
                    return@OnActionSelectedListener true
                }
            }
        })
    }

    private fun showAllGen() {
        val dialog = GenerationFragment()
        dialog.show(childFragmentManager, "")
    }

    private fun showSearch() {
        val dialog = SearchFragment()
        dialog.show(childFragmentManager, "")
    }

    override fun onDestroyView() {
        viewBinding = null
        super.onDestroyView()
    }
}

package dev.marcosfarias.pokedex.presentation.ui.dashboard.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.databinding.FragmentAboutBinding
import dev.marcosfarias.pokedex.presentation.extentions.observeWithLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel

class AboutFragment : Fragment() {

    private val viewModel: AboutViewModel by viewModel()
    private var viewBinding: FragmentAboutBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = checkNotNull(arguments?.getString("id"))
        viewModel.loadPokemonInfo(id)
        viewBinding = FragmentAboutBinding.bind(view)

        viewModel.uiPokemonState.observeWithLifecycle(
            viewLifecycleOwner = viewLifecycleOwner,
            block = { pokemon ->
                viewBinding?.apply {
                    textViewDescription.text = pokemon?.xDescription.orEmpty()
                    textViewHeight.text = pokemon?.height.orEmpty()
                    textViewWeight.text = pokemon?.weight.orEmpty()
                    textViewEggCycle.text = pokemon?.cycles.orEmpty()
                    textViewEggGroups.text = pokemon?.eggGroups.orEmpty()
                    textViewBaseEXP.text = pokemon?.baseExp.orEmpty()
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
        fun newInstance(id: String?) = AboutFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }
}

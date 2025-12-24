package dev.marcosfarias.pokedex.presentation.ui.dashboard.stats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.databinding.FragmentStatsBinding
import dev.marcosfarias.pokedex.presentation.extentions.observeWithLifecycle
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatsFragment : Fragment() {

    private val viewModel: StatsViewModel by viewModel()
    private var viewBinding: FragmentStatsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_stats, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding = FragmentStatsBinding.bind(view)

        val id = checkNotNull(arguments?.getString("id"))
        viewModel.getStats(id)

        viewModel.statsState.observeWithLifecycle(
            viewLifecycleOwner = viewLifecycleOwner,
            block = { pokemon ->
                viewBinding?.apply {
                    textViewTypeDefenses.text = pokemon?.yDescription.orEmpty()

                    textViewHP.text = pokemon?.hp.toString()
                    textViewAttack.text = pokemon?.attack.toString()
                    textViewDefense.text = pokemon?.defense.toString()
                    textViewSpAtk.text = pokemon?.specialAttack.toString()
                    textViewSpDef.text = pokemon?.specialDefense.toString()
                    textViewSpeed.text = pokemon?.speed.toString()
                    textViewTotal.text = pokemon?.total.toString()

                    progressBarHP.progress = pokemon?.hp ?: 0
                    progressBarAttack.progress = pokemon?.attack ?: 0
                    progressBarDefense.progress = pokemon?.defense ?: 0
                    progressBarSpAtk.progress = pokemon?.specialAttack ?: 0
                    progressBarSpDef.progress = pokemon?.specialDefense ?: 0
                    progressBarSpeed.progress = pokemon?.speed ?: 0
                    progressBarTotal.progress = pokemon?.total ?: 0
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
        fun newInstance(id: String?) = StatsFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }
}

package dev.marcosfarias.pokedex.presentation.ui.dashboard

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.bumptech.glide.Glide
import dev.marcosfarias.pokedex.R
import dev.marcosfarias.pokedex.databinding.FragmentDashboardBinding
import dev.marcosfarias.pokedex.presentation.extentions.observeWithLifecycle
import dev.marcosfarias.pokedex.utils.ImageLoadingListener
import dev.marcosfarias.pokedex.utils.convertToPokemonColor
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModel()
    private var dashboardViewBinding: FragmentDashboardBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(requireContext())
            .inflateTransition(R.transition.image_shared_element_transition)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        postponeEnterTransition()
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = checkNotNull(arguments?.getString("id"))
        val name = checkNotNull(arguments?.getString("name"))

        dashboardViewModel.getPokemonById(id)

        dashboardViewBinding = FragmentDashboardBinding.bind(view)

        dashboardViewBinding?.imageView?.transitionName = name

//        requireActivity().enableEdgeToEdge()

        dashboardViewModel.dashboardState.observeWithLifecycle(
            viewLifecycleOwner = viewLifecycleOwner,
            block = { pokemon ->
                dashboardViewBinding?.textViewID?.text = pokemon?.id
                dashboardViewBinding?.textViewName?.text = pokemon?.name

                val color = pokemon?.typeOfPokemon.convertToPokemonColor(requireContext())

                dashboardViewBinding?.appBar?.setBackgroundColor(color)

                dashboardViewBinding?.toolbarLayout?.contentScrim?.colorFilter =
                    PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)

                pokemon?.typeOfPokemon?.getOrNull(0).let { firstType ->
                    dashboardViewBinding?.textViewType3?.text = firstType
                    dashboardViewBinding?.textViewType3?.isVisible = firstType != null
                }

                pokemon?.typeOfPokemon?.getOrNull(1).let { secondType ->
                    dashboardViewBinding?.textViewType2?.text = secondType
                    dashboardViewBinding?.textViewType2?.isVisible = secondType != null
                }

                pokemon?.typeOfPokemon?.getOrNull(2).let { thirdType ->
                    dashboardViewBinding?.textViewType1?.text = thirdType
                    dashboardViewBinding?.textViewType1?.isVisible = thirdType != null
                }

                dashboardViewBinding?.imageView?.let {
                    Glide.with(view.context)
                        .load(pokemon?.imageUrl)
                        .listener(ImageLoadingListener {
                            startPostponedEnterTransition()
                        })
                        .into(it)
                }
                val pager = dashboardViewBinding?.viewPager
                val tabs = dashboardViewBinding?.tabs
                pager?.adapter = ViewPagerAdapter(
                    supportFragmentManager = childFragmentManager,
                    context = requireContext(),
                    pokemonId = pokemon?.id.orEmpty()
                )
                tabs?.setupWithViewPager(pager)
            }
        )
    }

    override fun onDestroyView() {
        dashboardViewBinding = null
        super.onDestroyView()
    }
}

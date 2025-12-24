package dev.marcosfarias.pokedex.presentation.extentions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

fun <T> Flow<T>.observeWithLifecycle(
    viewLifecycleOwner: LifecycleOwner,
    block: suspend (T) -> Unit,
    minActiveState: Lifecycle.State = Lifecycle.State.STARTED
) = flowWithLifecycle(viewLifecycleOwner.lifecycle, minActiveState)
    .onEach(block)
    .launchIn(viewLifecycleOwner.lifecycleScope)
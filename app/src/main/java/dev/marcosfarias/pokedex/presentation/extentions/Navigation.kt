package dev.marcosfarias.pokedex.presentation.extentions

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

fun NavController.navigateSafety(
    @IdRes actionId: Int,
    args: Bundle,
    navOptions: NavOptions? = null,
    extras: Navigator.Extras? = null
) {
    currentDestination?.getAction(actionId)?.let {
        navigate(
            resId = actionId,
            args = args,
            navOptions = navOptions,
            navigatorExtras = extras
        )
    }
}
package com.example.testecarrefour.extensions

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import com.example.testecarrefour.R

private val navOptions = NavOptions.Builder()
    .setEnterAnim(R.anim.slide_in_right)
    .setExitAnim(R.anim.slide_out_left)
    .setPopEnterAnim(R.anim.slide_in_left)
    .setPopExitAnim(R.anim.slide_out_right)
    .build()

fun NavController.navigateWithAnimations(destinationId: Int, params: Bundle? = null, popIfExists: Boolean = false, selectedNavOptions: NavOptions = navOptions) {
    if (popIfExists) {
        if (!this.popBackStack(destinationId, false)) {
            this.navigate(destinationId, params, selectedNavOptions)
            return
        }
        return
    }
    this.navigate(destinationId, params, selectedNavOptions)
}

fun NavController.navigateWithAnimations(directions: NavDirections) {
    this.navigate(directions, navOptions)
}

fun NavController.navigateWithAnimationsFromBottom(destinationId: Int, params: Bundle? = null, popIfExists: Boolean = false) {
    val selectedNavOptions = NavOptions.Builder()
        .setEnterAnim(R.anim.slide_from_bottom)
        .build()

    navigateWithAnimations(destinationId, params, popIfExists, selectedNavOptions)
}
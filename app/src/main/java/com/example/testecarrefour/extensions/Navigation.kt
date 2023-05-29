package com.example.testecarrefour.extensions

import android.os.Bundle
import androidx.navigation.NavController
import com.example.testecarrefour.extensions.navigateWithAnimations

object Navigate {

    fun goToDestination(
        destinationInt: Int,
        navController: NavController,
        params: Bundle? = null,
        popIfExists: Boolean = false
    ) {
        navController.navigateWithAnimations(
            destinationInt,
            params,
            popIfExists
        )
    }
}

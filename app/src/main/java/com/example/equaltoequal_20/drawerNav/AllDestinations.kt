package com.example.equaltoequal_20.drawerNav

import androidx.navigation.NavHostController
import com.example.equaltoequal_20.drawerNav.AllDestinations.HOME
import com.example.equaltoequal_20.drawerNav.AllDestinations.SETTINGS

object AllDestinations {
    const val HOME = "Все проекты"
    const val SETTINGS = "Мои проекты"
}

class AppNavigationActions(private val navController: NavHostController) {

    fun navigateToHome() {
        navController.navigate(HOME) {
            popUpTo(HOME)
        }
    }

    fun navigateToSettings() {
        navController.navigate(SETTINGS) {
            launchSingleTop = true
            restoreState = true
        }
    }
}

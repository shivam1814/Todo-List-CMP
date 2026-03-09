package io.shivam.todo.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavRoute {
    @Serializable
    data object SplashScreen : NavRoute()
}
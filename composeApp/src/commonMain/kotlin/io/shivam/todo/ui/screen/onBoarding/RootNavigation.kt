package io.shivam.todo.ui.screen.onBoarding

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.shivam.todo.ui.navigation.RootNavGraph
import io.shivam.todo.ui.screen.MainNavigation
import io.shivam.todo.ui.theme.TodoColor

/**
 * Root Navigation that decides between Onboarding and Main app flow
 */
@Composable
fun RootNavigation(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Onboarding Navigation Graph
        composable(RootNavGraph.Onboarding.route) {
            val onboardingNavController = rememberNavController()
            OnboardingNavigation(
                navController = onboardingNavController,
                onOnboardingComplete = {
                    navController.navigate(RootNavGraph.Main.route) {
                        popUpTo(RootNavGraph.Onboarding.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // Main App Navigation Graph
        composable(RootNavGraph.Main.route) {
            val mainNavController = rememberNavController()
            Surface(
                color = TodoColor.LightPrimary.color
            ) {
                MainNavigation(navController = mainNavController)
            }
        }
    }
}
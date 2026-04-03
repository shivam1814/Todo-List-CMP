package io.shivam.todo.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.shivam.todo.ui.screen.AddProject
import io.shivam.todo.ui.screen.OnBoardingScreen
import io.shivam.todo.ui.screen.TaskScreen
import io.shivam.todo.ui.screen.homeScreen.HomeScreen

@Composable
fun AppNavHost(
    startDestination: NavRoute = NavRoute.AddProjectScreen,
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {

        composable<NavRoute.SplashScreen> { abc() }
        composable<NavRoute.Onboarding> { OnBoardingScreen() }
        composable<NavRoute.HomeScreen> {  }
        composable<NavRoute.TodoList> {  }
        composable<NavRoute.Home> { HomeScreen() }
        composable<NavRoute.TaskScreen> { TaskScreen(navController) }
        composable<NavRoute.AddProjectScreen> { AddProject() }

    }


}


@Composable
fun abc() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "shivam is here")
    }

}
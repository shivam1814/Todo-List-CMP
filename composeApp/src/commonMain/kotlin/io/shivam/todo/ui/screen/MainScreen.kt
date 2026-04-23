package io.shivam.todo.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import io.shivam.todo.ui.animatedBottomBar.CurvedBottomNavigation
import io.shivam.todo.ui.animatedBottomBar.models.CurveAnimationType
import io.shivam.todo.ui.animatedBottomBar.models.IconSource
import io.shivam.todo.ui.animatedBottomBar.models.NavItem
import io.shivam.todo.ui.navigation.NavRoute
import io.shivam.todo.ui.navigation.RootNavGraph
import io.shivam.todo.ui.screen.homeScreen.HomeScreen
import io.shivam.todo.ui.screen.homeScreen.MostUsedCategoryScreen
import io.shivam.todo.ui.screen.onBoarding.RootNavigation
import io.shivam.todo.ui.theme.TodoColor
import io.shivam.todo.ui.viewModel.OnBoardingViewModel
import kotlinx.coroutines.launch
import org.koin.compose.koinInject
import todo_list.composeapp.generated.resources.Res
import todo_list.composeapp.generated.resources.add
import todo_list.composeapp.generated.resources.briefcase
import todo_list.composeapp.generated.resources.calendar
import todo_list.composeapp.generated.resources.home
import todo_list.composeapp.generated.resources.user_octagon

@Composable
fun MainScreen(
    navController: NavHostController
) {
    val onBoardingViewModel: OnBoardingViewModel = koinInject()
    val scope = rememberCoroutineScope()

    var isLoading by remember { mutableStateOf(true) }
    var startDestination by remember { mutableStateOf(RootNavGraph.Main.route) }

    LaunchedEffect(Unit) {
        scope.launch {
            val currentRoute = onBoardingViewModel.getCurrentRoute()
            startDestination = if (currentRoute == NavRoute.Onboarding) {
                RootNavGraph.Onboarding.route
            } else {
                RootNavGraph.Main.route
            }
            isLoading = false
        }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        if (isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = TodoColor.Primary.color)
            }
        } else {
            RootNavigation(
                navController = navController,
                startDestination = startDestination
            )
        }
    }

}















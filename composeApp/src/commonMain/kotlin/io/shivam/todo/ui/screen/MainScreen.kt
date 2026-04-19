package io.shivam.todo.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import io.shivam.todo.ui.screen.homeScreen.HomeScreen
import io.shivam.todo.ui.screen.homeScreen.MostUsedCategoryScreen
import io.shivam.todo.ui.theme.TodoColor
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

    val bottomNavItem = remember{

        listOf(
            NavItem(
                icon = IconSource.Drawable(Res.drawable.home),
                label = "Home",
                route = NavRoute.Home
            ),
            NavItem(
                icon = IconSource.Drawable(Res.drawable.briefcase),
                label = "Tasks",
                route = NavRoute.TaskScreen
            ),
            NavItem(
                icon = IconSource.Drawable(Res.drawable.add),
                selectedIcon = IconSource.Drawable(Res.drawable.add),
                label = "Add",
                route = NavRoute.AddProjectScreen
            ),
            NavItem(
                icon = IconSource.Drawable(Res.drawable.calendar),
                label = "Calendar",
                route = NavRoute.SplashScreen
            ),
            NavItem(
                icon = IconSource.Drawable(Res.drawable.user_octagon),
                label = "Settings",
                route = NavRoute.SettingsScreen
            )
        )

    }

    val currentBackStackEntry by navController.currentBackStackEntryFlow
        .collectAsState(initial = navController.currentBackStackEntry)

    val currentRoute = currentBackStackEntry?.destination?.route

    val selectedIndex = bottomNavItem.indexOfFirst { item ->
        currentRoute?.contains(item.route::class.simpleName ?: "") == true
    }.coerceAtLeast(0)


    Surface(
        modifier = Modifier.navigationBarsPadding(),
        color = TodoColor.White.color
    ) {

        Box(modifier = Modifier.fillMaxSize()){
            NavHost(
                navController = navController,
                startDestination = NavRoute.Home,
                modifier = Modifier.fillMaxSize()
            ) {

                composable<NavRoute.Home> {
                    HomeScreen()
                }

                composable<NavRoute.TaskScreen> {
                    TaskScreen(navController)
                }

                composable<NavRoute.AddProjectScreen> {
                    AddProject(navController)
                }

                composable<NavRoute.SplashScreen> {
                    MostUsedCategoryScreen(navController)
                }

                composable<NavRoute.SettingsScreen> {
                    SettingsPage(navController)
                }

                /*composable<NavRoute.TestScreen> {
                    TestScreen()
                }*/

            }


            CurvedBottomNavigation(
                modifier = Modifier.align(Alignment.BottomCenter),
                items = bottomNavItem,
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    val selectedRoute = bottomNavItem[index].route

                    if(index == 0) {
                        navController.navigate(NavRoute.Home) {
                            popUpTo(0) {
                                inclusive = true
                            }
                            launchSingleTop = true
                        }
                        return@CurvedBottomNavigation
                    }

                    if(index !=selectedIndex) {
                        navController.navigate(selectedRoute){
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                curveAnimationType = CurveAnimationType.SMOOTH,
                enableHapticFeedback = true,
                showLabels = true,
                navBarBackgroundColor = TodoColor.LightPrimary.color,
                fabBackgroundColor = TodoColor.Primary.color,
                unselectedIconTint = TodoColor.Primary.color,
            )

        }

    }

}















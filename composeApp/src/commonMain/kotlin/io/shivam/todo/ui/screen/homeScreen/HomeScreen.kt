package io.shivam.todo.ui.screen.homeScreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import io.shivam.todo.ui.screen.onBoarding.TodoBackgroundScreen
import io.shivam.todo.ui.screen.homeScreen.components.HomePageContent

@Composable
@Preview
fun HomeScreen(navController: NavController) {
    Scaffold {

        TodoBackgroundScreen {
            HomePageContent(navController)
        }

    }
}
package io.shivam.todo

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import io.shivam.todo.ui.screen.MainScreen
import io.shivam.todo.ui.theme.TodoAppTheme

@Composable
@Preview
fun App() {

    TodoAppTheme {
        val navController = rememberNavController()
        /*AppNavHost(
            navController = navController
        )*/
        MainScreen(navController)
    }
}
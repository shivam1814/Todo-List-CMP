package io.shivam.todo.ui.screen.homeScreen

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.shivam.todo.ui.animatedBottomBar.CurvedBottomNavigation
import io.shivam.todo.ui.screen.TodoBackgroundScreen
import io.shivam.todo.ui.screen.homeScreen.components.HomePageContent
import io.shivam.todo.ui.screen.homeScreen.components.navItems

@Composable
@Preview
fun HomeScreen() {
    var selectedIndex by remember { mutableStateOf(0) }
    Scaffold {

        TodoBackgroundScreen {
            HomePageContent()
        }

    }
}
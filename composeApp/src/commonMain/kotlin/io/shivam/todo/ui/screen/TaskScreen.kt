package io.shivam.todo.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import io.shivam.todo.data.model.ScheduleTaskModel
import io.shivam.todo.ui.animatedBottomBar.CurvedBottomNavigation
import io.shivam.todo.ui.components.CarousalCalendar
import io.shivam.todo.ui.components.CurvedButton
import io.shivam.todo.ui.components.CurvedButtonConfig
import io.shivam.todo.ui.components.ScheduleTaskCard
import io.shivam.todo.ui.components.TodoTopAppBar
import io.shivam.todo.ui.screen.homeScreen.components.navItems
import io.shivam.todo.ui.theme.Spacing
import io.shivam.todo.ui.theme.TodoColor
import io.shivam.todo.ui.uiutils.HSpacer
import io.shivam.todo.ui.uiutils.VSpacer

@Composable
@Preview
fun TaskScreen(navController: NavController = rememberNavController()) {

    val selected = remember { mutableStateOf("All") }
    val chips = listOf<String>(
        "All",
        "To do",
        "on Going",
        "Completed",
        "Pause"
    )

    val scheduleCards = List(5) { ScheduleTaskModel() }

    TodoBackgroundScreen {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TodoTopAppBar(
                modifier = Modifier.statusBarsPadding().systemBarsPadding(),
                navController = navController
            )
            CarousalCalendar()
            VSpacer(Spacing.s4)

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(chips) { idx, title ->
                    val curr = chips[idx]
                    if (idx == 0) HSpacer(Spacing.s4)

                    CurvedButton(
                        modifier = Modifier.width(150.dp).height(40.dp),
                        text = title,
                        buttonConfig = CurvedButtonConfig(
                            containerColor = if (curr == selected.value) TodoColor.Primary.color else TodoColor.LightPrimary.color,
                            contentColor = if (curr == selected.value) TodoColor.Light.color else TodoColor.Primary.color,
                            fontSize = 14.sp,
                            verticalBulgeFactor = 8f,
                            cornerRadius = 28f,
                            gradientShadowColor = Color.Transparent
                        )
                    ) {
                        selected.value = title
                    }

                    if (idx == chips.lastIndex) {
                        HSpacer(Spacing.s4)
                    }
                }
            }
            VSpacer(Spacing.s4)
            LazyColumn(
                modifier = Modifier.padding(Spacing.s4)
            ) {
                items(scheduleCards) {
                    ScheduleTaskCard()
                }
            }

        }


        CurvedBottomNavigation(
            modifier = Modifier.align(Alignment.BottomCenter),
            items = navItems,
            selectedIndex = 1,
            showDot = false,
            enableFabIconScale = true,
            enableHapticFeedback = false
        ) { index ->

        }


    }


}
package io.shivam.todo.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import io.shivam.todo.data.model.TaskGroupCategory
import io.shivam.todo.ui.components.SelectionCard
import io.shivam.todo.ui.components.SelectionCardConfig
import io.shivam.todo.ui.components.TodoTopAppBar
import io.shivam.todo.ui.theme.Spacing
import io.shivam.todo.ui.theme.TodoAppTheme
import kotlinx.coroutines.launch

@Composable
@Preview
fun AddProject(navHostController: NavHostController = rememberNavController()) {

    var openTaskGroupSection by remember { mutableStateOf(false) }
    val textChange by remember { mutableStateOf("") }
    val textDescription by remember { mutableStateOf("") }
    val selectedGroupCategory by remember { mutableStateOf(TaskGroupCategory.DailyStudy) }
    val openDatePicker by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    TodoBackgroundScreen {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TodoTopAppBar(
                modifier = Modifier.systemBarsPadding(),
                title = "Add Project",
                navController = navHostController
            )

            Column(
                modifier = Modifier.fillMaxWidth().padding(Spacing.s4),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                SelectionCard(
                    cardConfig = SelectionCardConfig(
                        title = "Task Group",
                        subtitle = "Work",
                        leadingIcon = {
                            Box(
                                modifier = Modifier
                                    .size(Spacing.s8)
                                    .background(
                                        color = selectedGroupCategory.color.copy(alpha = 0.15f),
                                        shape = CircleShape
                                    ),
                                contentAlignment = Alignment.Center
                            ) {

                                Icon(
                                    imageVector = selectedGroupCategory.icon,
                                    contentDescription = selectedGroupCategory.displayName,
                                    tint = selectedGroupCategory.color,
                                    modifier = Modifier.size(Spacing.s4)
                                )

                            }
                        }
                    )
                ) {
                    scope.launch {
                        openTaskGroupSection = !openTaskGroupSection
                    }
                }

                //project name


            }
        }


    }

}
package io.shivam.todo.ui.screen.homeScreen.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.shivam.todo.data.model.InProgressTask
import io.shivam.todo.data.model.TaskCategory
import io.shivam.todo.data.model.TaskGroup
import io.shivam.todo.data.model.TaskGroupCategory
import io.shivam.todo.ui.navigation.NavRoute
import io.shivam.todo.ui.theme.BodyLarge
import io.shivam.todo.ui.theme.Spacing
import io.shivam.todo.ui.theme.TodoColor
import io.shivam.todo.ui.uiutils.HSpacer
import io.shivam.todo.ui.uiutils.VSpacer
import io.shivam.todo.ui.viewModel.HomeScreenViewModel
import org.koin.compose.koinInject

@Composable
fun HomePageContent(
    navController: NavController,
    viewModel: HomeScreenViewModel = koinInject()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier.padding(Spacing.s4)
        ) {
            UserHeader(userProfile = uiState.userProfile)
            VSpacer(Spacing.s6)
            TaskProgressCard(
                progress = uiState.todayProgress,
                onViewTaskClick = {
                    navController.navigate(NavRoute.TaskScreen)
                }
            )
            if(uiState.inProgressTasks.isNotEmpty()) {
                VSpacer(Spacing.s4)
                SectionHeader(
                    title = "In Progress",
                    count = uiState.inProgressTasks.size
                )
            }
        }

        AnimatedVisibility(
            visible = uiState.inProgressTasks.isNotEmpty()
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(
                    items = uiState.inProgressTasks,
                    key = { _, task -> task.id }
                ) { idx, task ->
                    if (idx == 0) HSpacer(Spacing.s4)
                    InProgressTaskCard(task)
                    if (idx == uiState.inProgressTasks.lastIndex) {
                        HSpacer(Spacing.s4)
                    }
                }
            }
        }

        Column(
            modifier = Modifier.padding(Spacing.s4)
        ) {
            SectionHeader(
                title = "Task Group",
                count = uiState.taskGroups.size
            )

            if (uiState.taskGroups.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = Spacing.s12),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No task groups yet",
                        style = BodyLarge().copy(
                            color = TodoColor.Secondary.color,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            } else {
                uiState.taskGroups.forEach { taskGroup ->
                    TaskGroupCard(taskGroup)
                }
            }
        }

        VSpacer(Spacing.s55)
    }
}
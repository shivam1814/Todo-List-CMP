package io.shivam.todo.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import io.shivam.todo.data.model.TaskGroupCategory
import io.shivam.todo.ui.components.CurvedButton
import io.shivam.todo.ui.components.DatePickerDialog
import io.shivam.todo.ui.components.EditDetailCard
import io.shivam.todo.ui.components.SelectGroupBottomSheet
import io.shivam.todo.ui.components.SelectionCard
import io.shivam.todo.ui.components.SelectionCardConfig
import io.shivam.todo.ui.components.TodoTopAppBar
import io.shivam.todo.ui.theme.BodyXLarge
import io.shivam.todo.ui.theme.Spacing
import io.shivam.todo.ui.theme.TodoAppTheme
import io.shivam.todo.ui.theme.TodoColor
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import todo_list.composeapp.generated.resources.Res
import todo_list.composeapp.generated.resources.calendar

@Composable
@Preview
fun AddProject(navHostController: NavHostController = rememberNavController()) {

    var openTaskGroupSelection by remember { mutableStateOf(false) }
    var textChange by remember { mutableStateOf("") }
    var textDescription by remember { mutableStateOf("") }
    val selectedGroupCategory by remember { mutableStateOf(TaskGroupCategory.DailyStudy) }
    var openDatePicker by remember { mutableStateOf(false) }
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
                        openTaskGroupSelection = !openTaskGroupSelection
                    }
                }

                //project name
                EditDetailCard(
                    value = textChange,
                    placeHolderText = "Uber designing",
                    textStyle = BodyXLarge(),
                    onTextChange = {
                        textChange = it
                    }
                )

                //Description
                EditDetailCard(
                    value = textDescription,
                    title = "Description",
                    placeHolderText = "Add project description here",
                    textStyle = BodyXLarge(),
                    onTextChange = { alphabet ->
                        textDescription = alphabet
                    }
                )
                
                //Start Date
                SelectionCard (
                    cardConfig = SelectionCardConfig (
                        title = "Start Date",
                        subtitle = "17 Nov, 2025",
                        leadingIcon = {
                            Image(
                                painter = painterResource(Res.drawable.calendar),
                                contentDescription = "",
                                colorFilter = ColorFilter.tint(
                                    color = TodoColor.Primary.color
                                )
                            )
                        }
                    )
                ) {
                    scope.launch {
                        openDatePicker = !openDatePicker
                    }
                }

                //end Date
                SelectionCard (
                    cardConfig = SelectionCardConfig (
                        title = "End Date",
                        subtitle = "20 Nov, 2025",
                        leadingIcon = {
                            Image(
                                painter = painterResource(Res.drawable.calendar),
                                contentDescription = "",
                                colorFilter = ColorFilter.tint(
                                    color = TodoColor.Primary.color
                                )
                            )
                        }
                    )
                ) {
                    scope.launch {
                        openDatePicker = !openDatePicker
                    }
                }


                // Take all the available Space below
                Spacer(modifier = Modifier.weight(1f))


                CurvedButton (
                    modifier = Modifier,
                    text = "Add Project"
                ) {  }



            }
        }

        if (openTaskGroupSelection)
            SelectGroupBottomSheet(
                onDismiss = {
                    openTaskGroupSelection = false
                }
            )

        if(openDatePicker)
            DatePickerDialog(
                onDateSelected = {},
                onDismiss = {
                    openDatePicker = false
                }
            )


    }

}
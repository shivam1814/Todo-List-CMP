package io.shivam.todo.ui.screen.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import io.shivam.todo.data.model.InProgressTask
import io.shivam.todo.data.model.TaskCategory
import io.shivam.todo.ui.theme.BodyLarge
import io.shivam.todo.ui.theme.BodySmall
import io.shivam.todo.ui.theme.Spacing
import io.shivam.todo.ui.theme.TodoColor
import io.shivam.todo.ui.uiutils.VSpacer

@Composable
@Preview
fun InProgressTaskCard(
    task: InProgressTask = InProgressTask(
        id = "1",
        title = "Working on jetpack compose",
        category = TaskCategory.Office,
        progressPercentage = 0.3f,
    )
) {


    Box(
        modifier = Modifier
            .height(Spacing.s30)
            .width(Spacing.s55)
            .background(
                color = task.category.backgroundColor,
                shape = RoundedCornerShape(Spacing.s4)
            )
            .padding(Spacing.s4)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = task.category.displayName,
                style = BodySmall().copy(
                    color = TodoColor.Secondary.color
                )
            )
            VSpacer(Spacing.s2)
            Text(
                text = task.title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = BodyLarge().copy(
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start
                )
            )
            VSpacer(Spacing.s3)
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth(),
                progress = { task.progressPercentage },
                trackColor = TodoColor.GreyBackground.color,
                color = task.category.progressColor
            )

        }

    }


}









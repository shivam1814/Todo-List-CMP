package io.shivam.todo.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import io.shivam.todo.ui.theme.BodyLarge
import io.shivam.todo.ui.theme.BodyXSmall
import io.shivam.todo.ui.theme.Spacing
import io.shivam.todo.ui.theme.TodoColor
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import todo_list.composeapp.generated.resources.Res
import todo_list.composeapp.generated.resources.arrow___down_4

@Composable
@Preview(showBackground = true)
fun SelectionCard(
    modifier: Modifier = Modifier,
    cardConfig: SelectionCardConfig = SelectionCardConfig(),
    onClick: (() -> Unit)? = null
) {

    TodoElevatedCard(
        onClick = onClick
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(Spacing.s2),
                verticalAlignment = Alignment.CenterVertically
            ) {
                cardConfig.leadingIcon?.let { leading ->
                    leading()
                }

                Column(
                    horizontalAlignment = Alignment.Start,
                ) {

                    Text(
                        text = cardConfig.title,
                        style = BodyXSmall().copy(
                            color = TodoColor.Secondary.color
                        )
                    )

                    Text(
                        modifier = Modifier.align(Alignment.Start).padding(end = Spacing.s20),
                        text = cardConfig.subtitle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = BodyLarge().copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                }
            }

            cardConfig.trailingIcon?.let {
                Image(
                    painter = painterResource(it),
                    contentDescription = ""
                )
            }


        }

    }


}

data class SelectionCardConfig(
    val title: String = "Task Group",
    val subtitle: String = "Work",
    val leadingIcon: (@Composable () -> Unit)? = null,
    val trailingIcon: DrawableResource? = Res.drawable.arrow___down_4,
)
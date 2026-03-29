package io.shivam.todo.ui.screen.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import io.shivam.todo.ui.components.CurvedButton
import io.shivam.todo.ui.components.CurvedButtonConfig
import io.shivam.todo.ui.theme.BodyLarge
import io.shivam.todo.ui.theme.BodyXLarge
import io.shivam.todo.ui.theme.Spacing
import io.shivam.todo.ui.theme.TodoColor
import io.shivam.todo.ui.uiutils.HSpacer
import io.shivam.todo.ui.uiutils.VSpacer

@Composable
@Preview(showBackground = true)
fun TaskProgressCard() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = TodoColor.Primary.color,
                shape = RoundedCornerShape(Spacing.s6)
            )
            .padding(Spacing.s6)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Your Today's task \nalmost done",
                    style = BodyLarge().copy(
                        color = TodoColor.Light.color
                    )
                )
                VSpacer(Spacing.s6)
                CurvedButton(
                    modifier = Modifier,
                    onClick = {},
                    text = "View Task",
                    buttonConfig = CurvedButtonConfig(
                        cornerRadius = 40f,
                        verticalBulgeFactor = 10f,
                        containerColor = TodoColor.Light.color,
                        contentColor = TodoColor.Dark.color,
                        gradientShadowColor = Color.Transparent
                    )
                )

            }

            HSpacer(Spacing.s6)

            //progressbar
            Box(
                modifier = Modifier
                    .size(Spacing.s25),
                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator(
                    progress = { 0.7f },
                    modifier = Modifier.size(Spacing.s25),
                    strokeWidth = Spacing.s2,
                    color = Color.White,
                    trackColor = Color.White.copy(alpha = 0.2f)
                )
                Text(
                    text = "70%",
                    style = BodyXLarge().copy(
                        fontWeight = FontWeight.Bold,
                        color = TodoColor.Light.color
                    )
                )

            }

        }


    }

}
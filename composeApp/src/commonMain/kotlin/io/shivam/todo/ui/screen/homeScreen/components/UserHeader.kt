package io.shivam.todo.ui.screen.homeScreen.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.AsyncImage
import io.shivam.todo.data.model.UserProfile
import io.shivam.todo.ui.theme.BodyLarge
import io.shivam.todo.ui.theme.BodySmall
import io.shivam.todo.ui.theme.BodyXXLarge
import io.shivam.todo.ui.theme.Spacing
import io.shivam.todo.ui.theme.TodoColor
import io.shivam.todo.ui.uiutils.HSpacer
import todo_list.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.painterResource
import todo_list.composeapp.generated.resources.compose_multiplatform
import todo_list.composeapp.generated.resources.new_notification
import todo_list.composeapp.generated.resources.user_octagon

@Composable
@Preview(showBackground = true)
fun UserHeader(
    userProfile: UserProfile = UserProfile()
) {

    val shouldShowNotificationDot = remember { mutableStateOf(true) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(Spacing.s14)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                if (userProfile.photoData != null) {
                    AsyncImage(
                        model = userProfile.photoData,
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .size(Spacing.s14)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                } else if (userProfile.name.isNotEmpty()) {
                    Text(
                        userProfile.name.first().uppercase(),
                        style = BodyXXLarge().copy(
                            color = TodoColor.Light.color
                        )
                    )
                } else {
                    Image(
                        painter = painterResource(Res.drawable.user_octagon),
                        contentDescription = "Default Profile Picture",
                        colorFilter = ColorFilter.tint(
                            color = TodoColor.Primary.color
                        ),
                        modifier = Modifier
                            .size(Spacing.s14),
                    )
                }
            }

            HSpacer()
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Hello!",
                    style = BodySmall()
                )
                Text(
                    text = if (userProfile.name.isNotEmpty()) userProfile.name else "User",
                    style = BodyLarge()
                )
            }

        }

        Box(
            modifier = Modifier.size(Spacing.s6)
        ) {
            Image(
                painter = painterResource(Res.drawable.new_notification),
                contentDescription = null
            )

            if(shouldShowNotificationDot.value) Box(
                modifier = Modifier.offset(x = -Spacing.s1).size(Spacing.s2).background(
                    color = TodoColor.Primary.color,
                    shape = CircleShape
                ).align (Alignment.TopEnd),
            )
        }
    }
}
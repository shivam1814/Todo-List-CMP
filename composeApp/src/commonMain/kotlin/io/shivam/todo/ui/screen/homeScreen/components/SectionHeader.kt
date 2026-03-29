package io.shivam.todo.ui.screen.homeScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import io.shivam.todo.ui.theme.BodySmall
import io.shivam.todo.ui.theme.BodyXLarge
import io.shivam.todo.ui.theme.Spacing
import io.shivam.todo.ui.theme.TodoColor
import io.shivam.todo.ui.uiutils.HSpacer

@Composable
@Preview(showBackground = true)
fun SectionHeader(
    title:String = "progress",
    count: Int? = null
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Spacing.s4),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = BodyXLarge().copy(fontWeight = FontWeight.Bold)
        )
        
        if(count!=null) {
            HSpacer(Spacing.s2)
            Box(
                modifier = Modifier
                    .size(Spacing.s5)
                    .background(
                        color = TodoColor.LightPrimary.color,
                        shape = RoundedCornerShape(Spacing.s5)
                    )
                    .padding(Spacing.sHalf),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = count.toString(),
                    style = BodySmall().copy(
                        color = TodoColor.Primary.color
                    )
                )
            }

        }

    }

}
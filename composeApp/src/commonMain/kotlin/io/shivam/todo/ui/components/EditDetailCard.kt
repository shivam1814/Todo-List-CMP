package io.shivam.todo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.shivam.todo.ui.theme.BodyLarge
import io.shivam.todo.ui.theme.BodySmall
import io.shivam.todo.ui.theme.Spacing
import io.shivam.todo.ui.theme.TodoColor

@Composable
@Preview
fun EditDetailCard(
    title : String = "Project Name",
    value : String = "",
    placeHolderText : String = "",
    singleLine : Boolean = false,
    textStyle : TextStyle =  BodyLarge(),
    onTextChange : (String) -> Unit
) {

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = Spacing.s2)
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(Spacing.s4),
                ambientColor = TodoColor.Black.color.copy(alpha = 0.05f),
                spotColor = TodoColor.Black.color.copy(alpha = 0.12f)
            )
            .clip(RoundedCornerShape(Spacing.s4))
            .background(TodoColor.White.color),
        verticalArrangement = Arrangement.spacedBy(Spacing.s1),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            modifier = Modifier.padding(start = Spacing.s4, end = Spacing.s4, top = Spacing.s2),
            text = title,
            style = BodySmall().copy(
                color = TodoColor.Secondary.color
            )
        )
        TodoTextField(
            value = value,
            onValueChange = onTextChange,
            textColor = TodoColor.Dark.color,
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent,
            placeholder = placeHolderText,
            singleLine = singleLine,
            textStyle = textStyle
        )
    }

}
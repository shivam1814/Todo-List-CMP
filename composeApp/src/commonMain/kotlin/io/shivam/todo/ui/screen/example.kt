package io.shivam.todo.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun DrawCustomShape() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {

        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val width = size.width
            val height = size.height

            val path = Path().apply {
                moveTo(width / 3f, height / 2f)
                lineTo(width / 1.5f, height / 2f)
                lineTo(width / 2f, height / 3f)
                close()
            }

            drawPath(
                path = path,
                color = Color.Black
            )


        }

    }

}
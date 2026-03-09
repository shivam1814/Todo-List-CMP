package io.shivam.todo.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import todo_list.composeapp.generated.resources.Manrope_Bold
import todo_list.composeapp.generated.resources.Manrope_ExtraBold
import todo_list.composeapp.generated.resources.Manrope_Medium
import todo_list.composeapp.generated.resources.Manrope_Regular
import todo_list.composeapp.generated.resources.Manrope_SemiBold
import todo_list.composeapp.generated.resources.Res

@Composable
fun manropeFontFamily() = FontFamily(

    Font(Res.font.Manrope_Regular, weight = FontWeight.Normal),
    Font(Res.font.Manrope_Medium, weight = FontWeight.Medium),
    Font(Res.font.Manrope_SemiBold, weight = FontWeight.SemiBold),
    Font(Res.font.Manrope_Bold, weight = FontWeight.Bold),
    Font(Res.font.Manrope_ExtraBold, weight = FontWeight.Black),


)
package io.shivam.todo.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
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

/**
 * Font size 32.sp
 */
@Composable
fun H1TextStyle() = TextStyle(
    fontFamily = manropeFontFamily(),
    fontWeight = FontWeight.Bold,
    color = MaterialTheme.colorScheme.onSurface,
    fontSize = 32.sp,
)

/**
 * Font size 28.sp
 */
@Composable
fun H2TextStyle() = TextStyle(
    fontFamily = manropeFontFamily(),
    fontWeight = FontWeight.Bold,
    color = MaterialTheme.colorScheme.onSurface,
    fontSize = 28.sp,
)

/**
 * Font size 24.sp
 */
@Composable
fun H3TextStyle() = TextStyle(
    fontFamily = manropeFontFamily(),
    fontWeight = FontWeight.SemiBold,
    color = MaterialTheme.colorScheme.onSurface,
    fontSize = 24.sp,
)

/**
 * Font size 20.sp
 */

@Composable
fun BodyXXLarge() = TextStyle(
    fontFamily = manropeFontFamily(),
    fontWeight = FontWeight.Medium,
    color = MaterialTheme.colorScheme.onSurface,
    fontSize = 20.sp,
)

/**
 * Font size 18.sp
 */
@Composable
fun BodyXLarge() = TextStyle(
    fontFamily = manropeFontFamily(),
    fontWeight = FontWeight.Medium,
    color = MaterialTheme.colorScheme.onSurface,
    fontSize = 18.sp,
)

/**
 * Font size 16.sp
 */
@Composable
fun BodyLarge() = TextStyle(
    fontFamily = manropeFontFamily(),
    fontWeight = FontWeight.Medium,
    color = MaterialTheme.colorScheme.onSurface,
    fontSize = 16.sp,
)

/**
 * Font size 14.sp
 */
@Composable
fun BodyNormal() = TextStyle(
    fontFamily = manropeFontFamily(),
    fontWeight = FontWeight.Medium,
    color = MaterialTheme.colorScheme.onSurface,
    fontSize = 14.sp,
)

/**
 * Font size 12.sp
 */
@Composable
fun BodySmall() = TextStyle(
    fontFamily = manropeFontFamily(),
    fontWeight = FontWeight.Medium,
    color = MaterialTheme.colorScheme.onSurface,
    fontSize = 12.sp,
)

/**
 * Font size 10.sp
 */
@Composable
fun BodyXSmall() = TextStyle(
    fontFamily = manropeFontFamily(),
    fontWeight = FontWeight.Normal,
    color = MaterialTheme.colorScheme.onSurface,
    fontSize = 10.sp,
)
package io.shivam.todo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import io.shivam.todo.ui.theme.BodySmall
import io.shivam.todo.ui.theme.H3TextStyle
import io.shivam.todo.ui.theme.Spacing
import io.shivam.todo.ui.theme.TodoColor
import io.shivam.todo.ui.uiutils.VSpacer
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime
import kotlin.math.abs
import kotlin.time.Clock

@Composable
@Preview
fun CarousalCalendar() {

    val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date

    val year = today.year

    val startDate = LocalDate(year, 1, 1)
    val endDate = LocalDate(year, 12, 31)

    val dates = remember {
        generateSequence(startDate) { date ->
            val next = date.plus(1, DateTimeUnit.DAY)
            if (next <= endDate) next else null
        }.toList()
    }

    var selectedDate by remember { mutableStateOf(today) }

    BoxWithConstraints(
        modifier = Modifier.fillMaxWidth()
    ) {
        DialerWeekCalendar(
            dates = dates,
            selectedDate = selectedDate,
            onDateSelected = { selectedDate = it },
            maxWidth = maxWidth
        )
    }

}


@Composable
fun DialerWeekCalendar(
    modifier: Modifier = Modifier,
    dates: List<LocalDate>,
    selectedDate: LocalDate,
    onDateSelected: (LocalDate) -> Unit,
    maxWidth: Dp,
) {

    val listState = rememberLazyListState()
    var isInitialLoad by remember { mutableStateOf(false) }

    LaunchedEffect(selectedDate) {
        val selectedIndex = dates.indexOf(selectedDate)
        if (selectedIndex != -1) {
            if (isInitialLoad) {
                listState.scrollToItem(selectedIndex)
                isInitialLoad = false
            } else {
                listState.animateScrollToItem(index = selectedIndex)
            }
        }

    }

    LazyRow(
        modifier = Modifier.fillMaxWidth()
            .height(Spacing.s30),
        state = listState,
        horizontalArrangement = Arrangement.spacedBy(Spacing.s3),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = (maxWidth/2) - 46.dp)
    ) {

        items(dates.size) { index ->
            val date = dates[index]

            // Calculate the center position dynamically
            val layoutInfo = listState.layoutInfo
            val viewportCenter = layoutInfo.viewportStartOffset + (layoutInfo.viewportEndOffset - layoutInfo.viewportStartOffset) / 2

            val itemInfo = layoutInfo.visibleItemsInfo.find { it.index == index }
            val itemCenter = itemInfo?.let { it.offset + it.size / 2 } ?: 0

            // Calculate distance from center
            val distanceFromCenter = if (itemInfo != null) {
                abs(viewportCenter - itemCenter).toFloat() / layoutInfo.viewportSize.width
            } else {
                1f
            }

            val scale = (1f - (distanceFromCenter * 0.3f)).coerceIn(0.7f, 1f)
            val rotationY = (distanceFromCenter * 40f).coerceAtMost(45f)
            val alpha = (1f - (distanceFromCenter * 0.5f)).coerceIn(0.5f, 1f)

            Box(
                modifier = Modifier
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        this.rotationY = if (itemCenter < viewportCenter) rotationY else -rotationY
                        this.alpha = alpha
                    }
                    .clip(RoundedCornerShape(Spacing.s4))
                    .background(
                        if (date == selectedDate) TodoColor.Primary.color
                        else TodoColor.Light.color
                    )
                    .clickable {
                        onDateSelected(date)
                    }
                    .width(Spacing.s20)
                    .height(Spacing.s25),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = date.month.name.take(3),
                        style = BodySmall().copy(
                            color = if (date == selectedDate) Color.White.copy(alpha = 0.8f)
                            else Color.DarkGray
                        )
                    )
                    VSpacer(Spacing.s1)
                    Text(
                        text = date.day.toString(),
                        style = H3TextStyle().copy(
                            fontWeight = FontWeight.Bold,
                            color = if (date == selectedDate) Color.White else Color.Black
                        ),
                    )
                    VSpacer(Spacing.s1)
                    Text(
                        text = date.dayOfWeek.name.take(3),
                        style = BodySmall().copy(
                            color = if (date == selectedDate) Color.White.copy(alpha = 0.8f)
                            else Color.Gray
                        ),
                    )
                }
            }

        }

    }

}











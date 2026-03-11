package io.shivam.todo.data.model

import kotlin.time.Instant

data class TodoItem(
    val id: Long,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val createdAt: Instant = Instant.fromEpochMilliseconds(0)
)

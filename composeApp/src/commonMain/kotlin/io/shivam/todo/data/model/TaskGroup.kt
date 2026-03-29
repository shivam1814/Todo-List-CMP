package io.shivam.todo.data.model

data class TaskGroup(
    val id: String,
    val category: TaskGroupCategory,
    val taskCount: Int,
    val completionPercentage: Int
)
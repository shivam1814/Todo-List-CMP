package io.shivam.todo.data.model

data class InProgressTask(
    val id: String,
    val title: String,
    val category: TaskCategory,
    val progressPercentage: Float,
    val icon: String? = null
)
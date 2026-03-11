package io.shivam.todo.domain

import io.shivam.todo.data.model.TodoItem

interface TodoRepository {

    suspend fun getAllTodo(): List<TodoItem>
    suspend fun addTodo(todo: TodoItem)
    suspend fun deleteTodo(todo: TodoItem)

}
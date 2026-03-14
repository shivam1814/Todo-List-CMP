package io.shivam.todo.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.shivam.todo.data.TodoRepositoryImpl
import io.shivam.todo.data.model.TodoItem
import io.shivam.todo.domain.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository) : ViewModel() {

    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    val todos: StateFlow<List<TodoItem>> = _todos

    fun loadTodos() {
        viewModelScope.launch {
            _todos.value = repository.getAllTodo()
        }
    }

    fun addTodo(todo: TodoItem) {
        viewModelScope.launch {
            repository.addTodo(todo)
        }
    }

    fun deleteTodo(todo: TodoItem) {
        viewModelScope.launch {
            repository.deleteTodo(todo)
        }
    }
}
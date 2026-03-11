package io.shivam.todo

import io.shivam.todo.data.TodoRepositoryImpl
import io.shivam.todo.domain.TodoRepository
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

private var isKoinInitialized = false

val appModule = module {
    single<TodoRepository> {
        TodoRepositoryImpl()
    }
    factory {

    }
}

fun initKoin() {
    if (!isKoinInitialized) {
        startKoin {
            modules(appModule)
        }
        isKoinInitialized = false
    }
}

fun resetKoin() {
    stopKoin()
    isKoinInitialized = false
    initKoin()
}

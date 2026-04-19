package io.shivam.todo

import io.shivam.todo.data.TodoRepositoryImpl
import io.shivam.todo.domain.TodoRepository
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.dsl.module

private var koinRef: Koin? = null

val appModule = module {
    single<TodoRepository> {
        TodoRepositoryImpl()
    }
    factory {

    }
}

fun initKoin(config: (KoinApplication) -> Unit = {}) {
    if(koinRef == null) {
        val app = startKoin {
            config(this)
            modules(appModule, platformModule())
        }
    }
}


fun resetKoin() {
    stopKoin()
    koinRef = null
    initKoin()
}

expect fun platformModule() : Module

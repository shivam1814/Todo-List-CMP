package io.shivam.todo

import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

private var isKoinInitialized = false

val appModule = module {
    single {

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

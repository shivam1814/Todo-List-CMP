package io.shivam.todo

import androidx.room.RoomDatabase
import io.shivam.todo.data.TodoRepositoryImpl
import io.shivam.todo.data.local.AppDatabase
import io.shivam.todo.domain.TodoRepository
import io.shivam.todo.ui.viewModel.AddProjectViewModel
import io.shivam.todo.ui.viewModel.EditTodoViewModel
import io.shivam.todo.ui.viewModel.HomeScreenViewModel
import io.shivam.todo.ui.viewModel.MostUsedCategoryViewModel
import io.shivam.todo.ui.viewModel.OnBoardingViewModel
import io.shivam.todo.ui.viewModel.SettingsViewModel
import io.shivam.todo.ui.viewModel.TaskScreenViewModel
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.dsl.module

private var koinRef: Koin? = null

val appModule = module {
    single { get<RoomDatabase.Builder<AppDatabase>>().build() }
    single { get<AppDatabase>().getDao() }
    single { get<AppDatabase>().getUserProfileDao() }
    single { OnBoardingViewModel(get()) }
    single<TodoRepository> { TodoRepositoryImpl() }
    single { AddProjectViewModel(get()) }
    single { EditTodoViewModel(get()) }
    single { TaskScreenViewModel(get()) }
    single { HomeScreenViewModel(get(), get()) }
    single { SettingsViewModel(get(), get()) }
    single { MostUsedCategoryViewModel(get()) }
}

fun initKoin(config: (KoinApplication) -> Unit = {}) {
    if(koinRef == null) {
        val app = startKoin {
            config(this)
            modules(appModule, platformModule())
        }
        koinRef = app.koin
    }
}


fun resetKoin() {
    stopKoin()
    koinRef = null
    initKoin()
}

expect fun platformModule() : Module


fun getKoin(): Koin =
    koinRef ?: throw Throwable("Koin is not initialized. Call initKoin() first.")
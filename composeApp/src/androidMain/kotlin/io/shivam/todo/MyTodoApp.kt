package io.shivam.todo

import android.app.Application

class MyTodoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(this)
    }
}
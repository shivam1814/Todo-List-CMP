package io.shivam.todo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
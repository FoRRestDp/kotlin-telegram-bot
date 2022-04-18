@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.kotlin)
}

dependencies {
    implementation(libs.coroutines.core)
    implementation(projects.telegram)
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "com.github.kotlintelegrambot.MainKt")
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from({ configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) } })
}

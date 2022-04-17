plugins {
    alias(libs.plugins.kotlin)
}

dependencies {
    implementation(libs.ktor.serverCio)
    implementation(projects.telegram)
}

val runApp by tasks.creating(JavaExec::class) {
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("com.github.kotlintelegrambot.webhook.MainKt")
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "com.github.kotlintelegrambot.MainKt")
    }

    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    from({ configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) } })
}

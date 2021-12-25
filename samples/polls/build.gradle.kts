plugins {
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation(project(":telegram"))
}

tasks.jar {
    manifest {
        attributes(mapOf("Main-Class" to "com.github.kotlintelegrambot.MainKt"))
    }


    from({ configurations.getByName("compile").map { if (it.isDirectory) it else zipTree(it) } })
}

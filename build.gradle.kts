import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.atomicfu) apply false
}

allprojects {
    apply(from = "$rootDir/ktlint.gradle")

    group = "com.github.forrestdp.kotlintelegrambot"
    version = "8.0.0-alpha01"

    tasks.withType<KotlinCompile> {
        kotlinOptions.freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
    }
}

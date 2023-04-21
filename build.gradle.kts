plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.atomicfu) apply false
}

allprojects {
    apply(from = "$rootDir/ktlint.gradle")

    group = "com.github.forrestdp.kotlintelegrambot"
    version = "8.0.0-alpha01"
}

@file:Suppress("UnstableApiUsage")

rootProject.name = "kotlin-telegram-bot"

include(":telegram")
if (!System.getenv("JITPACK").toBoolean()) {
    include(":echo", ":dispatcher", ":polls", ":webhook")

    project(":echo").projectDir = File(rootDir, "samples/echo")
    project(":dispatcher").projectDir = File(rootDir, "samples/dispatcher")
    project(":polls").projectDir = File(rootDir, "samples/polls")
    project(":webhook").projectDir = File(rootDir, "samples/webhook")
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        register("libs") {
            val kotlin = version("kotlin", "1.8.10")
            val retrofit = version("retrofit", "2.9.0")
            val okhttp = version("okhttp", "4.10.0")
            val coroutines = version("coroutines", "1.6.4")
            val ktor = version("ktor", "2.2.4")
            val assertj = version("assertj", "3.24.2")
            val mockk = version("mockk", "1.13.4")
            val atomicfu = version("atomicfu", "0.20.0")
            val junit = version("junit", "5.9.2")
            val compatabilityValidator = version("compatabilityValidator", "0.13.0")

            val kotlinxGroup = "org.jetbrains.kotlinx"
            val retrofitGroup = "com.squareup.retrofit2"
            val okhttpGroup = "com.squareup.okhttp3"
            val junitJupiterGroup = "org.junit.jupiter"

            plugin("kotlin", "org.jetbrains.kotlin.jvm").versionRef(kotlin)
            plugin("atomicfu", "org.jetbrains.kotlin.plugin.atomicfu").versionRef(kotlin)
            plugin("compatabilityValidator", "org.jetbrains.kotlinx.binary-compatibility-validator").versionRef(
                compatabilityValidator)

            library("retrofit-core", retrofitGroup, "retrofit").versionRef(retrofit)
            library("retrofit-converterGson", retrofitGroup, "converter-gson").versionRef(retrofit)
            library("okhttp-loggingInterceptor", okhttpGroup, "logging-interceptor").versionRef(okhttp)
            library("coroutines-core", kotlinxGroup, "kotlinx-coroutines-core").versionRef(coroutines)
            library("ktor-serverCio", "io.ktor", "ktor-server-cio").versionRef(ktor)
            library("atomicfu-core", kotlinxGroup, "atomicfu").versionRef(atomicfu)
            library("assertj-core", "org.assertj", "assertj-core").versionRef(assertj)
            library("mockk-core", "io.mockk", "mockk").versionRef(mockk)
            library("okhttp-mockwebserver", okhttpGroup, "mockwebserver").versionRef(okhttp)
            library("coroutines-test", kotlinxGroup, "kotlinx-coroutines-test").versionRef(coroutines)
            library("junit-jupiterCore", junitJupiterGroup, "junit-jupiter").versionRef(junit)
            library("junit-jupiterApi", junitJupiterGroup, "junit-jupiter-api").versionRef(junit)
            library("junit-jupiterParams", junitJupiterGroup, "junit-jupiter-params").versionRef(junit)

            bundle("junit", listOf("junit-jupiterCore", "junit-jupiterApi", "junit-jupiterParams"))
        }
    }
}

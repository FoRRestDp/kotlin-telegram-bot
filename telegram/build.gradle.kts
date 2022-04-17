import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    alias(libs.plugins.compatabilityValidator)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.atomicfu)
}

group = "com.github.forrestdp.kotlintelegrambot"
version = "7.0.0"

kotlin {
    explicitApi = ExplicitApiMode.Strict
}

dependencies {
    // Networking
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converterGson)

    implementation(libs.okhttp.loggingInterceptor)

    implementation(libs.coroutines.core)

    implementation(libs.atomicfu.core)

    // Testing
    testImplementation(libs.bundles.junit)
    testImplementation(libs.assertj.core)
    testImplementation(libs.mockk.core)
    testImplementation(libs.okhttp.mockwebserver)
    testImplementation(libs.coroutines.test)
}

val sourcesJar by tasks.creating(Jar::class) {
    dependsOn(tasks.classes.get())
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

artifacts {
    archives(sourcesJar)
}

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.compileTestKotlin {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.test {
    useJUnitPlatform()
}

import org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode

plugins {
    alias(libs.plugins.compatabilityValidator)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.atomicfu)
    `maven-publish`
    java
}

java {
    withSourcesJar()
    withJavadocJar()
}

kotlin {
    jvmToolchain(11)
    explicitApi = ExplicitApiMode.Strict
}

tasks.test {
    useJUnitPlatform()
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

//val sourcesJar by tasks.creating(Jar::class) {
//    dependsOn(tasks.classes.get())
//    archiveClassifier.set("sources")
//    from(sourceSets.main.get().allSource)
//}
//
//artifacts {
//    archives(sourcesJar)
//}

publishing {
    publications {
        register<MavenPublication>("maven") {
            group = project.group
            artifactId = project.name
            version = project.version.toString()
            from(components["java"])

            pom.name.set("Kotlin Telegram Bot Coroutines")
        }
    }
}

tasks.register<Wrapper>("wrapper") {
    gradleVersion = "8.1"
    distributionType = Wrapper.DistributionType.ALL
}

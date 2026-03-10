plugins {
    java
    id("com.gradleup.shadow") version "8.3.10"
}

group = "me.a8kj.spigot.events.gradletemplate"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    compileOnly("com.github.azbh111:spigot-1.8.8:R")
    compileOnly("com.google.auto.service:auto-service-annotations:1.1.1")
    annotationProcessor("com.google.auto.service:auto-service:1.1.1")
    implementation("com.github.a8kj7sea:Events:v1.2")
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    relocate("me.a8kj.spigot.events.hub", "me.a8kj.spigot.events.internal.hub")
    relocate("me.a8kj.spigot.events.spool", "me.a8kj.spigot.events.internal.spool")
    relocate("me.a8kj.spigot.events.asm", "me.a8kj.spigot.events.internal.asm")

    mergeServiceFiles()
    archiveClassifier.set("")
}

tasks.build {
    dependsOn("shadowJar")
}
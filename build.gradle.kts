import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
    application
}

group = "org.cezsecurity"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("commons-io:commons-io:2.11.0")

    testImplementation(kotlin("test"))
    testImplementation("io.mockk:mockk:1.12.1")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("org.cezsecurity.MainKt")
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}
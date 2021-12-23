val javaVersion = JavaVersion.VERSION_17
val ktorVersion = "1.6.7"
val log4jVersion = "2.17.0"

plugins {
    application
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
    id("com.github.johnrengelman.shadow") version "7.1.1"
    id("com.github.ben-manes.versions") version "0.39.0"
    id("io.gitlab.arturbosch.detekt").version("1.19.0")
}

repositories {
    mavenCentral()
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.19.0")
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(kotlin("stdlib"))
    implementation("org.apache.logging.log4j:log4j-api:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-core:$log4jVersion")
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4jVersion")
    implementation("io.github.microutils:kotlin-logging-jvm:2.1.21")
    implementation("io.ktor:ktor-server:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-auth:$ktorVersion")
    implementation("io.ktor:ktor-auth-jwt:$ktorVersion")
    implementation("io.ktor:ktor-locations:$ktorVersion")
    implementation("io.ktor:ktor-metrics-micrometer:$ktorVersion")
    implementation("io.ktor:ktor-auth:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("io.ktor:ktor-client-serialization:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-logging:$ktorVersion")
    implementation("no.nav.security:token-client-core:1.3.9")
    implementation("com.auth0:java-jwt:3.18.2")
    implementation("com.auth0:jwks-rsa:0.20.0")
    implementation("io.micrometer:micrometer-registry-prometheus:1.8.1")

    // DB
    implementation("org.flywaydb:flyway-core:8.2.3")
    implementation("com.zaxxer:HikariCP:5.0.0")
    implementation("org.postgresql:postgresql:42.3.1")
    implementation("com.github.seratch:kotliquery:1.6.1")
    testImplementation("org.apache.kafka:kafka-clients:3.0.0")
    testImplementation("org.apache.avro:avro:1.11.0")

    // Use the Kotlin test library.
    testImplementation(kotlin("test"))
}

application {
    mainClass.set("no.nav.tpts.mottak.AppKt")
}

java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
}

// https://github.com/ben-manes/gradle-versions-plugin
fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = javaVersion.toString()
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = javaVersion.toString()
    }
    test {
        // JUnit 5 support
        useJUnitPlatform()
    }
    shadowJar {
        dependsOn("test")
    }
    // https://github.com/ben-manes/gradle-versions-plugin
    dependencyUpdates {
        rejectVersionIf {
            isNonStable(candidate.version)
        }
    }
}

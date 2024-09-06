plugins {
    kotlin("jvm") version "1.7.10"
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.13.RELEASE"
    kotlin("plugin.spring") version "1.7.10"
    kotlin("plugin.jpa") version "1.7.10"
}

subprojects {
    apply(plugin = "java")

    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")

    apply {
        plugin("org.jetbrains.kotlin.kapt")
        version = "1.7.10"
    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-data-jpa")
        implementation("org.springframework.boot:spring-boot-starter")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.kotest:kotest-runner-junit5:5.8.1")
        testImplementation("io.mockk:mockk:1.13.11")
    }
}

allprojects {
    group = "com.daegusw.apply"
    version = "0.0.1"

    tasks {
        compileKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "17"
            }
        }

        compileJava {
            sourceCompatibility = JavaVersion.VERSION_17.majorVersion
        }

        test {
            useJUnitPlatform()
        }
    }

    repositories {
        mavenCentral()
    }
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
}
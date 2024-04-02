plugins {
    //alias(libs.plugins.kotlin.jvm)
    kotlin("jvm") version "1.9.21"
}

repositories { mavenCentral() }

subprojects {
    group = "com.dgswiphak"
    version = "0.0.1-SNAPSHOT"

    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    apply {
        plugin("org.jetbrains.kotlin.kapt")
    }

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

    dependencies {
        val libs = rootProject.libs

        implementation(libs.bundles.kotlin)
        implementation(libs.bundles.jackson)
    }
}
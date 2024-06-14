plugins {
    alias(libs.plugins.allopen)
}

allOpen { annotation("com.dgswiphak.ida.common.annotation.UseCase") }

dependencies {
    testImplementation(libs.kotest)
    testImplementation(libs.mockk)
}

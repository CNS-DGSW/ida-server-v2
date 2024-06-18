plugins {
    alias(libs.plugins.allopen)
}

allOpen { annotation("com.dgswiphak.ida.common.annotation.UseCase") }

dependencies{
    implementation(libs.spring.validation)
}
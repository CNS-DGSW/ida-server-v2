dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("aws.sdk.kotlin:ses:0.16.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("org.springframework.boot:spring-boot-starter-mail")
    implementation(project(":applicant:applicant-application"))
}
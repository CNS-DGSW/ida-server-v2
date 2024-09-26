dependencies {
    implementation(project(":notice:notice-domain"))
    implementation(project(":notice:notice-application"))

    implementation(project(":core:file"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
}
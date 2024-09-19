dependencies {
    implementation(project(":core:authentication"))

    implementation(project(":member:member-id"))

    implementation(project(":admission:admission-domain"))
    implementation(project(":admission:admission-application"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
}
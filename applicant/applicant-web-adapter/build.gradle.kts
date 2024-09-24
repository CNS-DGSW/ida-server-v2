dependencies {
    implementation(project(":core:authentication"))
    implementation(project(":core:file"))

    implementation(project(":member:member-id"))

    implementation(project(":applicant:applicant-domain"))
    implementation(project(":applicant:applicant-application"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}
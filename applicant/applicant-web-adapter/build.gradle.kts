dependencies {
    implementation(project(":core:authentication"))
    implementation(project(":core:file"))

    implementation(project(":member:member-id"))

    implementation(project(":applicant:applicant-domain"))
    implementation(project(":applicant:applicant-application"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
}
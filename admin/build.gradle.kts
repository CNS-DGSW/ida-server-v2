dependencies {
    implementation(project(":core:file"))
    implementation(project(":core:excel"))
    implementation(project(":core:data"))

    implementation(project(":member:member-id"))

    implementation(project(":applicant:applicant-domain"))
    implementation(project(":applicant:applicant-application"))
    implementation(project(":applicant:applicant-jpa-adapter"))

    implementation(project(":admission:admission-domain"))
    implementation(project(":admission:admission-application"))
    implementation(project(":admission:admission-jpa-adapter"))

    implementation(project(":secondary:secondary-domain"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
}
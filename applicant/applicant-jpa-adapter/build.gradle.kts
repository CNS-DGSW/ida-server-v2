dependencies {
    implementation(project(":core:data"))

    implementation(project(":member:member-id"))

    implementation(project(":applicant:applicant-domain"))
    implementation(project(":applicant:applicant-application"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
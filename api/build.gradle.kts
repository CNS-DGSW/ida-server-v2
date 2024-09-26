dependencies {
    implementation(project(":core:id-gen:core"))
    implementation(project(":core:id-gen:tsid"))

    implementation(project(":member:member-id"))
    implementation(project(":member:member-domain"))
    implementation(project(":member:member-application"))
    implementation(project(":member:member-jpa-adapter"))
    implementation(project(":member:member-web-adapter"))

    implementation(project(":applicant:applicant-application"))
    implementation(project(":applicant:applicant-jpa-adapter"))
    implementation(project(":applicant:applicant-web-adapter"))
    implementation(project(":applicant:applicant-s3-adapter"))

    implementation(project(":admission:admission-application"))
    implementation(project(":admission:admission-jpa-adapter"))
    implementation(project(":admission:admission-web-adapter"))

    implementation(project(":notice:notice-jpa-adapter"))
    implementation(project(":notice:notice-web-adapter"))
    implementation(project(":notice:notice-s3-adapter"))

    implementation(project(":secondary:secondary-jpa-adapter"))
    implementation(project(":secondary:secondary-web-adapter"))

    implementation(project(":auth:auth-application"))
    implementation(project(":auth:auth-web-adapter"))

    implementation("mysql:mysql-connector-java:8.0.33")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
}
dependencies {
    implementation(project(":notice:notice-domain"))
    implementation(project(":notice:notice-application"))

    implementation(project(":core:data"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
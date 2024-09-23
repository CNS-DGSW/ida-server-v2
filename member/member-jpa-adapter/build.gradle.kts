dependencies {
    implementation(project(":member:member-id"))
    implementation(project(":member:member-domain"))
    implementation(project(":member:member-application"))

    implementation(project(":core:data"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
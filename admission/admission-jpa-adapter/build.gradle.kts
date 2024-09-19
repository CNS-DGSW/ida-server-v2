dependencies {
    implementation(project(":core:data"))

    implementation(project(":member:member-id"))

    implementation(project(":admission:admission-domain"))
    implementation(project(":admission:admission-application"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
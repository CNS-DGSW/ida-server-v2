dependencies {
    implementation(project(":core:data"))

    implementation(project(":secondary:secondary-domain"))
    implementation(project(":secondary:secondary-application"))

    implementation(project(":admission:admission-domain"))
    implementation(project(":admission:admission-jpa-adapter"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
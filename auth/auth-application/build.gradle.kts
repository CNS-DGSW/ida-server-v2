dependencies {
    implementation(project(":member:member-id"))
    implementation(project(":member:member-domain"))
    implementation(project(":member:member-application"))
    implementation(project(":core:hash"))

    implementation("com.auth0:java-jwt:4.4.0")
}
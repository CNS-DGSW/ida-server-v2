dependencies {
    implementation(project(":member:member-id"))
    implementation(project(":applicant:applicant-domain"))

    //for web-client
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("io.netty:netty-resolver-dns-native-macos:4.1.85.Final:osx-aarch_64")
}
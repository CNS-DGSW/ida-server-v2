dependencies {

	implementation(project(":core:file"))

	implementation(project(":notice:notice-domain"))
	implementation(project(":notice:notice-application"))

	implementation("com.amazonaws:aws-java-sdk-s3:1.12.704")
	implementation("org.springframework.boot:spring-boot-starter-web")
}
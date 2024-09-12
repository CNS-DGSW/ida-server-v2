dependencies {
	implementation(project(":notice:notice-domain"))
	implementation(project(":notice:notice-application"))

	//implementation("org.springframework.cloud:spring-cloud-starter-aws:2.2.6.RELEASE")
	implementation("com.amazonaws:aws-java-sdk-s3:1.12.704")
}
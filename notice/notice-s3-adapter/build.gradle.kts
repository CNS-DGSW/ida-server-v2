dependencies {
	implementation(project(":notice:notice-domain"))
	implementation(project(":notice:notice-application"))

	implementation(project(":core:data"))

	implementation("io.awspring.cloud:spring-cloud-starter-aws")
	implementation("com.amazonaws:aws-java-sdk-s3:1.12.619")
}
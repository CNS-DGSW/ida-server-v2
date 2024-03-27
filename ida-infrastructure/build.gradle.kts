plugins {
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.kotlin.jpa)
	alias(libs.plugins.spring.management)
}


dependencies {
	implementation(project(":ida-domain"))

	implementation(libs.connector.mysql)
	implementation(libs.redis)

	implementation(libs.bundles.jjwt.impl)
	runtimeOnly(libs.bundles.jjwt.runtime)

	implementation(libs.spring.data.jpa)
	implementation(variantOf(libs.querydsl.jpa) { classifier("jakarta") } )
	kapt(variantOf(libs.querydsl.apt) { classifier("jakarta") } )

	implementation(libs.spring.aws.s3)

	testImplementation(libs.bundles.test)
}

allOpen {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

noArg {
	annotation("jakarta.persistence.Entity")
	annotation("jakarta.persistence.MappedSuperclass")
	annotation("jakarta.persistence.Embeddable")
}

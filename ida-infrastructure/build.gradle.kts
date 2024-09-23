/*
plugins {
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.kotlin.jpa)
	alias(libs.plugins.spring.management)
}


dependencies {
	implementation(project(":ida-domain"))

	implementation(libs.spring.web)

	implementation(libs.connector.mysql)
	implementation(libs.redis)

	implementation(libs.bundles.jjwt.impl)
	runtimeOnly(libs.bundles.jjwt.runtime)

	implementation(libs.spring.data.jpa)
	implementation(variantOf(libs.querydsl.jpa) { classifier("jakarta") } )
	kapt(variantOf(libs.querydsl.apt) { classifier("jakarta") } )

	implementation(libs.spring.aws.s3)

	implementation(libs.apache.poi)
	implementation(libs.apache.poi.ooxml)

	testImplementation(libs.bundles.test)

	implementation(files("libs/lsh.jar"))
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
}*/

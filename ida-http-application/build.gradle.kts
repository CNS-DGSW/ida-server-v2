plugins {
	alias(libs.plugins.kotlin.spring)
	alias(libs.plugins.spring.boot)
	alias(libs.plugins.spring.management)
}

dependencies {
	implementation(project(":ida-domain"))
	implementation(project(":ida-infrastructure"))
	implementation(libs.bundles.spring)
	implementation(libs.bundles.test)
}

plugins {
	id("org.springframework.boot") version PluginVersions.SPRINGBOOT_VERSION
	id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
	kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2022.0.5")
	}
}

dependencies {
	implementation(project(":ida-domain"))
	implementation(project(":ida-infrastructure"))
	implementationDependencies(Libraries.Feign)
	implementationDependencies(Libraries.SpringBoot)
}

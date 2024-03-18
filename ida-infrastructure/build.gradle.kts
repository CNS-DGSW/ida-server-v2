plugins {
	kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
	kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
	id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:2022.0.5")
	}
}

dependencies {
	implementation(project(":ida-domain"))
	implementationDependencies(Libraries.Feign)
	implementationDependencies(Libraries.Database)
	implementationDependencies(Libraries.Redis)
	implementationDependencies(Libraries.JWT)
	implementationDependencies(Libraries.JPA)
	implementationDependencies(Libraries.Querydsl)
	implementationDependencies(Libraries.Test)
	implementationDependencies(Libraries.Aws)
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

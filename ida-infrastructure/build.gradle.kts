plugins {
	kotlin("plugin.jpa") version PluginVersions.JPA_PLUGIN_VERSION
	kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
}

dependencies {
	implementation(project(":ida-domain"))
	implementationDependencies(Libraries.Database)
	implementationDependencies(Libraries.Redis)
	implementationDependencies(Libraries.JWT)
	implementationDependencies(Libraries.JPA)
	implementationDependencies(Libraries.Querydsl)
	implementationDependencies(Libraries.Test)
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

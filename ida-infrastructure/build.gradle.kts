plugins {
	kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
}

dependencies {
	implementationDependencies(Libraries.Database)
	implementationDependencies(Libraries.JPA)
	implementationDependencies(Libraries.Querydsl)
	implementationDependencies(Libraries.Test)
}

tasks.getByName<Jar>("jar") {
	enabled = false
}
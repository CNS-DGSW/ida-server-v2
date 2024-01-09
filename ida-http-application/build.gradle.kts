plugins {
	id("org.springframework.boot") version PluginVersions.SPRINGBOOT_VERSION
	id("io.spring.dependency-management") version PluginVersions.DEPENDENCY_MANAGER_VERSION
	kotlin("plugin.spring") version PluginVersions.SPRING_PLUGIN_VERSION
}

dependencies {
	implementationDependencies(Libraries.SpringBoot)
}

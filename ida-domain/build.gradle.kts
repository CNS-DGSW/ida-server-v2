plugins {
    kotlin("plugin.allopen") version PluginVersions.ALLOPEN_VERSION
}

allOpen {
    annotation("com.dgswiphak.ida.common.annotation.UseCase")
}
enum class DependencyScope(val originalName: String) {
    IMPLEMENTATION("implementation"),
    TEST_IMPLEMENTATION("testImplementation"),
    KAPT("kapt"),
    RUNTIME_ONLY("runtimeOnly")
}

data class Dependency(val name: String, val scope: DependencyScope)

interface Libraries {
    fun dependencies(): List<Dependency>

    object Kotlin : Libraries {
        private const val KOTLIN_REFLECT = "org.jetbrains.kotlin:kotlin-reflect"
        private const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"

        override fun dependencies(): List<Dependency> = listOf(
                Dependency(KOTLIN_REFLECT, DependencyScope.IMPLEMENTATION),
                Dependency(KOTLIN_STDLIB, DependencyScope.IMPLEMENTATION)
        )
    }

    object Jackson : Libraries {
        private const val MODULE_KOTLIN = "com.fasterxml.jackson.module:jackson-module-kotlin:${DependencyVersions.JACKSON_VERSION}"

        override fun dependencies(): List<Dependency> = listOf(
                Dependency(MODULE_KOTLIN, DependencyScope.IMPLEMENTATION)
        )
    }

    object SpringBoot : Libraries {
        private const val STARTER_WEB = "org.springframework.boot:spring-boot-starter-web"
        private const val STARTER_SECURITY = "org.springframework.boot:spring-boot-starter-security"
        private const val STARTER_VALIDATION = "org.springframework.boot:spring-boot-starter-validation"

        override fun dependencies(): List<Dependency> = listOf(
                Dependency(STARTER_WEB, DependencyScope.IMPLEMENTATION),
                Dependency(STARTER_SECURITY, DependencyScope.IMPLEMENTATION),
                Dependency(STARTER_VALIDATION, DependencyScope.IMPLEMENTATION)
        )
    }

    object JPA : Libraries {
        private const val DATA_JPA = "org.springframework.boot:spring-boot-starter-data-jpa:${PluginVersions.SPRINGBOOT_VERSION}"

        override fun dependencies(): List<Dependency> = listOf(
                Dependency(DATA_JPA, DependencyScope.IMPLEMENTATION)
        )
    }

    object Querydsl : Libraries {
        private const val QUERYDSL_JPA = "com.querydsl:querydsl-jpa:${DependencyVersions.QUERYDSL_VERSION}:jakarta"
        private const val QUERYDSL_APT = "com.querydsl:querydsl-apt:${DependencyVersions.QUERYDSL_VERSION}:jakarta"

        override fun dependencies(): List<Dependency> = listOf(
                Dependency(QUERYDSL_JPA, DependencyScope.IMPLEMENTATION),
                Dependency(QUERYDSL_APT, DependencyScope.KAPT)
        )
    }

    object JWT : Libraries {
        private const val JJWT_API = "io.jsonwebtoken:jjwt-api:0.11.5"
        private const val JJWT_IMPL = "io.jsonwebtoken:jjwt-impl:0.11.5"
        private const val JJWT_JACKSON = "io.jsonwebtoken:jjwt-jackson:0.11.5"
        override fun dependencies(): List<Dependency> = listOf(
            Dependency(JJWT_API, DependencyScope.IMPLEMENTATION),
            Dependency(JJWT_IMPL, DependencyScope.RUNTIME_ONLY),
            Dependency(JJWT_JACKSON, DependencyScope.RUNTIME_ONLY)
        )
    }

    object Database : Libraries {
        private const val MYSQL_CONNECTOR = "mysql:mysql-connector-java:${DependencyVersions.MYSQL_VERSION}"

        override fun dependencies(): List<Dependency> = listOf(
                Dependency(MYSQL_CONNECTOR, DependencyScope.RUNTIME_ONLY)
        )
    }

    object Redis : Libraries {
        private const val SPRING_REDIS = "org.springframework.boot:spring-boot-starter-data-redis:${PluginVersions.SPRINGBOOT_VERSION}"
        private const val DATA_REDIS = "org.springframework.data:spring-data-redis:${DependencyVersions.REDIS_VERSION}"
        override fun dependencies(): List<Dependency> = listOf(
            Dependency(SPRING_REDIS, DependencyScope.IMPLEMENTATION),
            Dependency(DATA_REDIS, DependencyScope.IMPLEMENTATION)
        )
    }

    object Feign : Libraries {
        private const val FEIGN = "org.springframework.cloud:spring-cloud-starter-openfeign"

        override fun dependencies() = listOf(
            Dependency(FEIGN, DependencyScope.IMPLEMENTATION)
        )
    }

    object Aws : Libraries {
        private const val SPRING_AWS = "io.awspring.cloud:spring-cloud-starter-aws:${DependencyVersions.AWS_VERSION}"

        override fun dependencies() = listOf (
            Dependency(SPRING_AWS, DependencyScope.IMPLEMENTATION)
        )
    }

    object Test : Libraries {
        private const val SPRING_TEST = "org.springframework.boot:spring-boot-starter-test:${PluginVersions.SPRINGBOOT_VERSION}"
        private const val MOCKITO_JUNIT = "org.mockito:mockito-junit-jupiter:${DependencyVersions.MOCKITO_VERSION}"
        private const val MOCKITO_CORE = "org.mockito:mockito-core:${DependencyVersions.MOCKITO_VERSION}"

        override fun dependencies() = listOf(
                Dependency(SPRING_TEST, DependencyScope.IMPLEMENTATION),
                Dependency(MOCKITO_JUNIT, DependencyScope.TEST_IMPLEMENTATION),
                Dependency(MOCKITO_CORE, DependencyScope.TEST_IMPLEMENTATION)
        )
    }

}
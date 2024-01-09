import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.implementationDependencies(libraries: Libraries) {
    libraries.dependencies().forEach { (name, scope) ->
        add(scope.originalName, name)
    }
}
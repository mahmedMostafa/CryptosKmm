import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.addComposeDependencies() {
    composeDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addNetworkCoreDependencies() {
    networkCoreDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addNetworkAndroidDependencies() {
    networkAndroidDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addHiltDependencies() {
    add("kapt", Hilt.compiler)
    hiltDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addNetworkIosDependencies() {
    networkIosDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addAndroidXDependencies() {
    androidXDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addCacheCoreDependencies() {
    cacheDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addCacheAndroidDependencies() {
    cacheDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addCacheIosDependencies() {
    cacheDependencies.forEach {
        add("implementation", it)
    }
}

fun DependencyHandler.addTestingDependencies() {
    testingDependencies.forEach {
        add("testImplementation", it)
    }
}




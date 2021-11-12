internal val composeDependencies = listOf(
    Compose.runtime,
    Compose.activity,
    Compose.compiler,
    Compose.constraintLayout,
    Compose.foundation,
    Compose.material,
    Compose.foundation,
    Compose.navigation,
    Compose.runtimeLiveData,
    Compose.ui,
    Compose.uiTooling,
    Compose.composeViewModel,
    Accompanist.coil
)

internal val androidXDependencies = listOf(
    AndroidX.appCompat,
    AndroidX.coreKtx,
)

internal val hiltDependencies = listOf(
    Hilt.android,
    Hilt.hiltNavigation
)

internal val composeThirdPartyDependencies = listOf(
    Accompanist.coil,
)

internal val cacheDependencies = listOf(
    SQLDelight.runtime
)

internal val cacheAndroidDependencies = listOf(
    SQLDelight.runtime
)

internal val cacheIosDependencies = listOf(
    SQLDelight.runtime
)

internal val networkCoreDependencies = listOf(
    Ktor.core,
    Ktor.clientSerialization,
)

internal val networkAndroidDependencies = listOf(
    Ktor.android
)


internal val networkIosDependencies = listOf(
    Ktor.ios
)
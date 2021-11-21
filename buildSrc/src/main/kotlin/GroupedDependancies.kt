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

internal val testingDependencies = listOf(
    Testing.mockk,
    Testing.mockJvm,
    Testing.hamcrest,
    Testing.junit4,
    Testing.turbine,
    AndroidXTest.core,
    AndroidXTest.junit,
    AndroidXTest.runner,
    Kotlinx.coroutinesTest,
)

internal val androidXDependencies = listOf(
    AndroidX.appCompat,
    AndroidX.coreKtx,
    AndroidX.splashScreen
)

internal val hiltDependencies = listOf(
    Hilt.android,
    Hilt.hiltNavigation
)

internal val composeThirdPartyDependencies = listOf(
    Accompanist.coil,
)

internal val cacheDependencies = listOf(
    SQLDelight.runtime,
    SQLDelight.extensions,
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
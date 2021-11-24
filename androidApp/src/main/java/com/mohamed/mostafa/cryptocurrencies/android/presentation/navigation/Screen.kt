package com.mohamed.mostafa.cryptocurrencies.android.presentation.navigation

sealed class Screen(val route: String) {

    object CryptoDetail : Screen("crypto_detail")

    object Search : Screen("search")
}

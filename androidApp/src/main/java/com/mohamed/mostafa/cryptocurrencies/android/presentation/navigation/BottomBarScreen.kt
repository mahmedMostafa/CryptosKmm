package com.mohamed.mostafa.cryptocurrencies.android.presentation.navigation

import androidx.annotation.StringRes
import com.mohamed.mostafa.cryptocurrencies.android.R

sealed class BottomBarScreen(val route: String, @StringRes val title: Int) {

    object Cryptos : BottomBarScreen("cryptos", R.string.market)

    object Events : BottomBarScreen("events", R.string.events)

    object Settings : BottomBarScreen("settings", R.string.settings)
}

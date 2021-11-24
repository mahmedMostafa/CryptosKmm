package com.mohamed.mostafa.cryptocurrencies.android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mohamed.mostafa.cryptocurrencies.android.R
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list.CryptosViewModel
import com.mohamed.mostafa.cryptocurrencies.android.presentation.navigation.Navigation
import com.mohamed.mostafa.cryptocurrencies.android.presentation.theme.CryptoTheme
import dagger.hilt.android.AndroidEntryPoint


@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            CryptoTheme {
                Navigation()
            }
        }
    }
}

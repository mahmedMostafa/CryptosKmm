package com.mohamed.mostafa.cryptocurrencies.android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.mohamed.mostafa.cryptocurrencies.android.R
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list.CryptosViewModel
import com.mohamed.mostafa.cryptocurrencies.android.presentation.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: CryptosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            Navigation()
        }
    }
}

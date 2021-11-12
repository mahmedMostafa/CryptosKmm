package com.mohamed.mostafa.cryptocurrencies.android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mohamed.mostafa.cryptocurrencies.Greeting
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.mohamed.mostafa.cryptocurrencies.android.R
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.CryptosScreen
import com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.CryptosViewModel
import com.mohamed.mostafa.cryptocurrencies.android.presentation.navigation.Navigation
import com.mohamed.mostafa.cryptocurrencies.presentation.cryptos.CryptosIntent
import dagger.hilt.android.AndroidEntryPoint

fun greet(): String {
    return Greeting().greeting()
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: CryptosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setContent {
            Navigation()
        }
    }
}

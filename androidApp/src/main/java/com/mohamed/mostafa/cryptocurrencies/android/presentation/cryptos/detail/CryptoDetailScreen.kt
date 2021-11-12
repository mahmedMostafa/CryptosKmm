package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun CryptoDetailScreen(
    viewModel: CryptoDetailViewModel,
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Crypto Detail Screen")
    }
}
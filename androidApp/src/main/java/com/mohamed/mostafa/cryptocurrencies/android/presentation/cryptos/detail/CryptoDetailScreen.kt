package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mohamed.mostafa.cryptocurrencies.android.base.components.DefaultScreen
import com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.presentation.CryptoDetailState


@Composable
fun CryptoDetailScreen(
    state: CryptoDetailState,
) {

    DefaultScreen(
        isLoading = state.isLoading,
        topBar = {}
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(state.crypto?.description ?: "")
        }
    }
}
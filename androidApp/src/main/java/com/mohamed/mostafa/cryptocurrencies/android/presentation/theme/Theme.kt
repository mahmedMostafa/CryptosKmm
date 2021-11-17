package com.mohamed.mostafa.cryptocurrencies.android.presentation.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun CryptoTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = LightColors,
        typography = MyTypography,
        shapes = AppShapes,
        content = content,
    )
}
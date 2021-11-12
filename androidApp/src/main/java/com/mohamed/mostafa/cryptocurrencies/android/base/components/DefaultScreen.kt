package com.mohamed.mostafa.cryptocurrencies.android.base.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun DefaultScreen(
    isLoading: Boolean,
    errorMessage: String? = null,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            content()

            if (isLoading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary
                )
            }

            if (errorMessage != null) {
                Text(
                    errorMessage,
                    style = MaterialTheme.typography.h5
                )
            }
        }
    }
}
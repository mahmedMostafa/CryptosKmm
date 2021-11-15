package com.mohamed.mostafa.cryptocurrencies.android.base.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun DefaultScreen(
    isLoading: Boolean,
    errorMessage: String? = null,
    topBar: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = topBar,
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
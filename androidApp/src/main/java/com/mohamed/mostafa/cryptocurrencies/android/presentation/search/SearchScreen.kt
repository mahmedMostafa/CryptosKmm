package com.mohamed.mostafa.cryptocurrencies.android.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import com.mohamed.mostafa.cryptocurrencies.android.presentation.search.components.SearchTextField


@ExperimentalComposeUiApi
@Composable
fun SearchScreen(
    query: String,
    onValueChange: (String) -> Unit,
    onDoneClick: () -> Unit,
) {
    Scaffold {
        Column {
            SearchTextField(query = query, onValueChange = onValueChange, onDoneClick = onDoneClick)
        }
    }
}
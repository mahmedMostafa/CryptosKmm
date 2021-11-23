package com.mohamed.mostafa.cryptocurrencies.android.presentation.search.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@ExperimentalComposeUiApi
@Composable
fun SearchTextField(
    query: String,
    onValueChange: (String) -> Unit,
    onDoneClick: () -> Unit,
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = query,
        onValueChange = { onValueChange(it) },
        label = {
            Text("Search", style = MaterialTheme.typography.body1)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search,
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                onDoneClick()
                keyboardController?.hide()
            },
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
}
package com.mohamed.mostafa.cryptocurrencies.android.base.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService.Constants.PAGINATION_PER_PAGE_COUNT


@Composable
fun <T> PaginatedLazyList(
    items: List<T>,
    isLoadingMore: Boolean,
    errorMessage: String? = null,
    currentPage: Int,
    getNextPage: () -> Unit,
    onRetryClick: () -> Unit,
    itemContent: @Composable (T) -> Unit,
) {

    LazyColumn {
        itemsIndexed(
            items = items,
        ) { index: Int, item: T ->
            if ((index + 1) >= (currentPage * PAGINATION_PER_PAGE_COUNT) && !isLoadingMore) {
                getNextPage()
            }

            itemContent(item)
        }
        item {
            if (isLoadingMore && errorMessage == null) {
                PaginationLoadingProgressBar()
            }
            if (errorMessage != null) {
                PaginationError(message = errorMessage) {
                    onRetryClick()
                }
            }
        }
    }
}

@Composable
fun PaginationError(
    message: String,
    onRetryClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(12.0.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(message, style = MaterialTheme.typography.body1)

        Button(onClick = { onRetryClick.invoke() }) {
            Text("Retry", style = MaterialTheme.typography.button)
        }
    }

}

@Composable
fun PaginationLoadingProgressBar() {
    Column(
        modifier = Modifier
            .padding(12.0.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircularProgressIndicator(
            color = MaterialTheme.colors.primary
        )
    }
}
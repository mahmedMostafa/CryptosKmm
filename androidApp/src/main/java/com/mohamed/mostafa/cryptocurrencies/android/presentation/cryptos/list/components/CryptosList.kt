package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.mohamed.mostafa.cryptocurrencies.android.base.components.PaginatedLazyList
import com.mohamed.mostafa.cryptocurrencies.domain.models.Crypto

@Composable
fun CryptosList(
    isLoadingMore: Boolean,
    items: List<Crypto>,
    page: Int,
    getNextPage: () -> Unit,
    onRetryClick: () -> Unit,
    onItemClick: (Crypto) -> Unit,
    errorMessage: String? = null,
) {
    PaginatedLazyList(
        items = items,
        errorMessage = errorMessage,
        isLoadingMore = isLoadingMore,
        currentPage = page,
        getNextPage = getNextPage,
        onRetryClick = onRetryClick,
        itemContent = { crypto ->
            CryptoListItem(crypto, onItemClick)
        }
    )
}

@Composable
fun CryptoListItem(item: Crypto, onItemClick: (Crypto) -> Unit) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .clickable {
                onItemClick(item)
            }
            .fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = rememberImagePainter(
                    data = item.image,
                    builder = {
                        transformations(CircleCropTransformation())
                        crossfade(true)
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(10.dp)
            )
            Text(
                item.name ?: "",
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.body1
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            Text(
                item.currentPrice?.toString() ?: "",
                style = MaterialTheme.typography.caption
            )
        }
    }
}
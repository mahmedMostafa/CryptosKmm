package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.mohamed.mostafa.cryptocurrencies.android.base.components.PaginatedLazyList
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto

@Composable
fun CryptosList(
    isLoadingMore: Boolean,
    items: List<Crypto>,
    page: Int,
    getNextPage: () -> Unit,
    onRetryClick: () -> Unit,
    onFavoriteClick: (Crypto) -> Unit,
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
            CryptoListItem(crypto, onItemClick, onFavoriteClick)
        }
    )
}

@Composable
fun CryptoListItem(item: Crypto, onItemClick: (Crypto) -> Unit, onFavoriteClick: (Crypto) -> Unit) {
    val isInFavorites = remember {
        mutableStateOf(item.isFavorite ?: false)
    }
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
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                style = MaterialTheme.typography.body1
            )
            Column {

                Text(
                    item.currentPrice?.toString() ?: "",
                    style = MaterialTheme.typography.caption
                )
                IconButton(
                    onClick = {
                        //we can safely change the icon right away since it's only stored locally (no errors!)
                        onFavoriteClick(item)
                        isInFavorites.value = !isInFavorites.value
                        item.isFavorite = !item.isFavorite!!
                    }
                ) {
                    Icon(
                        imageVector = if (isInFavorites.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = if (isInFavorites.value) Color.Red else MaterialTheme.colors.onSurface
                    )
                }
            }
        }
    }
}
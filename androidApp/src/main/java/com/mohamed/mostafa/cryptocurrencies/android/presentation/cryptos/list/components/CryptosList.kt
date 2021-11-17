package com.mohamed.mostafa.cryptocurrencies.android.presentation.cryptos.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.mohamed.mostafa.cryptocurrencies.android.R
import com.mohamed.mostafa.cryptocurrencies.android.base.components.PaginatedLazyList
import com.mohamed.mostafa.cryptocurrencies.android.presentation.theme.CryptoTheme
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.PriceState

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
fun CryptoListItem(
    item: Crypto,
    onItemClick: (Crypto) -> Unit,
    onFavoriteClick: (Crypto) -> Unit
) {
    val isInFavorites = remember {
        mutableStateOf(item.isFavorite ?: false)
    }
    val priceChangeIcon = remember {
        when (item.priceState) {
            PriceState.DID_GO_UP -> R.drawable.ic_arrow_upward
            PriceState.DID_GO_DOWN -> R.drawable.ic_arrow_downward
            else -> R.drawable.ic_menu
        }
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
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
            ) {
                Text(
                    item.symbol ?: "",
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Bold),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    item.name ?: "",
                    style = MaterialTheme.typography.body2,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painterResource(id = priceChangeIcon),
                        modifier = Modifier.size(20.dp),
                        contentDescription = null,
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        item.currentPrice?.toString() ?: "",
                        style = MaterialTheme.typography.body1
                    )
                }
//                Spacer(Modifier.height(4.dp))
//                IconButton(
//                    onClick = {
//                        //we can safely change the icon right away since it's only stored locally (no errors!)
//                        onFavoriteClick(item)
//                        isInFavorites.value = !isInFavorites.value
//                        item.isFavorite = !item.isFavorite!!
//                    }
//                ) {
//                    Icon(
//                        imageVector = if (isInFavorites.value) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
//                        contentDescription = null,
//                        tint = if (isInFavorites.value) Color.Red else MaterialTheme.colors.onSurface
//                    )
//                }
            }
        }
    }
}
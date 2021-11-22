package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.models

sealed class SearchSort {

    object ByName : SearchSort()
    object ByPrice : SearchSort()
}

package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.presentation.cryptos

sealed class CryptosActions {


    object GetCryptos : CryptosActions()

    object GetNextPage : CryptosActions()

    data class AddOrRemoveFromFavorites(val id: String) : CryptosActions()
}

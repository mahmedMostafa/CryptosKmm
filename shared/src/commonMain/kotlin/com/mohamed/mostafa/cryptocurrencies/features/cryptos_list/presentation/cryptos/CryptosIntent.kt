package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.presentation.cryptos

sealed class CryptosIntent {


    object GetCryptos : CryptosIntent()

    object GetNextPage : CryptosIntent()
}

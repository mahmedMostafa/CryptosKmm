package com.mohamed.mostafa.cryptocurrencies.presentation.cryptos

sealed class CryptosIntent {


    object GetCryptos : CryptosIntent()

    object GetNextPage : CryptosIntent()
}

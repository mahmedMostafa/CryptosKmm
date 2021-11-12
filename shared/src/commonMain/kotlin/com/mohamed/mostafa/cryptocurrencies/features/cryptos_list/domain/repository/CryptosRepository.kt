package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.repository

import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.models.Crypto


interface CryptosRepository {

    suspend fun getCryptos(page : Int): List<Crypto>
}
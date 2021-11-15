package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.repository

import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto


interface CryptosRepository {

    suspend fun getCryptos(page: Int): List<Crypto>

    suspend fun addOrRemoveFromFavorites(id: String)
}
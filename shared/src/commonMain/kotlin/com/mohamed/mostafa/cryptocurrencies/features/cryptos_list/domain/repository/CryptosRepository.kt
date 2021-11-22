package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.repository

import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.models.SearchSort
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto
import kotlinx.coroutines.flow.Flow


interface CryptosRepository {

    suspend fun getCryptos(page: Int): List<Crypto>

    suspend fun addOrRemoveFromFavorites(id: String)

    suspend fun searchCryptos(query: String, sort: SearchSort): Flow<List<Crypto>>
}
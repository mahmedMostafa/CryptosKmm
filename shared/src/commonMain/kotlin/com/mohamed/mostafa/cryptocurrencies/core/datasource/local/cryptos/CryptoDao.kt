package com.mohamed.mostafa.cryptocurrencies.core.datasource.local.cryptos

import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.models.SearchSort
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto
import kotlinx.coroutines.flow.Flow


interface CryptoDao {

    fun insertCrypto(crypto: Crypto)

    fun insertCryptos(cryptos: List<Crypto>)

    fun updateCryptoDetail(id: String, description: String)

    fun addOrRemoveFromFavorites(id: String)

    fun getCryptoById(id: String): Crypto

    fun getCryptos(page: Int): List<Crypto>

    fun getAllCryptos(): List<Crypto>

    fun searchCryptos(query: String, sort: SearchSort): List<Crypto>

    fun deleteCrypto(id: String)

    fun clearCryptos()
}
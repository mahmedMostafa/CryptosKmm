package com.mohamed.mostafa.cryptocurrencies.core.datasource.local.cryptos

import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto


interface CryptoDao {

    fun insertCrypto(crypto: Crypto)

    fun insertCryptos(cryptos: List<Crypto>)

    fun updateCryptoDetail(id: String, description: String)

    fun getCryptoById(id: String): Crypto

    fun getCryptos(page: Int): List<Crypto>

    fun getAllCryptos(): List<Crypto>

    fun deleteCrypto(id: String)

    fun clearCryptos()
}
package com.mohamed.mostafa.cryptocurrencies.data.local.cryptos

import com.mohamed.mostafa.cryptocurrencies.domain.models.Crypto

interface CryptoDao {

    fun insertCrypto(crypto: Crypto)

    fun insertCryptos(cryptos: List<Crypto>)

    fun getCryptoById(id: String): Crypto

    fun getCryptos(page: Int): List<Crypto>

    fun getAllCryptos(): List<Crypto>

    fun deleteCrypto(id: String)

    fun clearCryptos()
}
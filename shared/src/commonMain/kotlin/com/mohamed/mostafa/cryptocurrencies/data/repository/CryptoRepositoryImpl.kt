package com.mohamed.mostafa.cryptocurrencies.data.repository

import com.mohamed.mostafa.cryptocurrencies.data.local.cryptos.CryptoDao
import com.mohamed.mostafa.cryptocurrencies.data.remote.ApiService
import com.mohamed.mostafa.cryptocurrencies.domain.mappers.toDomainList
import com.mohamed.mostafa.cryptocurrencies.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.domain.repository.CryptosRepository

class CryptoRepositoryImpl(
    private val cryptoService: ApiService,
    private val cryptoCache: CryptoDao,
) : CryptosRepository {

    override suspend fun getCryptos(page: Int): List<Crypto> {
        try {
            val cryptos = cryptoService.getCryptos(page).toDomainList()

            cryptoCache.insertCryptos(cryptos)//TODO Handle Cache Errors

        } catch (e: Throwable) {
            e.printStackTrace()
        }
        return cryptoCache.getCryptos(page)
    }
}
package com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.data.repository

import com.mohamed.mostafa.cryptocurrencies.core.datasource.local.cryptos.CryptoDao
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService
import com.mohamed.mostafa.cryptocurrencies.data.cache.CryptosDatabase
import com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.domain.mappers.toDomainModel
import com.mohamed.mostafa.cryptocurrencies.features.crypto_detail.domain.repository.CryptoDetailRepository
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto

class CryptoDetailRepositoryImpl(
    private val cryptoService: ApiService,
    private val cryptoCache: CryptoDao,
) : CryptoDetailRepository {

    override suspend fun getCryptoDetail(id: String): Crypto {
        val data = cryptoService.getCryptoDetail(id)
        cryptoCache.updateCryptoDetail(id, data.description?.en ?: "")
        return cryptoCache.getCryptoById(id)
    }
}
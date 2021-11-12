package com.mohamed.mostafa.cryptocurrencies.data.repository

import com.mohamed.mostafa.cryptocurrencies.data.remote.ApiService
import com.mohamed.mostafa.cryptocurrencies.domain.mappers.toDomainList
import com.mohamed.mostafa.cryptocurrencies.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.domain.repository.CryptosRepository

class CryptoRepositoryImpl(
    private val apiService: ApiService,
) : CryptosRepository {

    override suspend fun getCryptos(page: Int): List<Crypto> {
        return apiService.getCryptos(page).toDomainList()
    }
}
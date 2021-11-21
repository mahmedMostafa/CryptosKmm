package com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.data.repository


import com.mohamed.mostafa.cryptocurrencies.core.datasource.local.cryptos.CryptoDao
import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.mappers.toDomainList
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.repository.CryptosRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

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

    override suspend fun addOrRemoveFromFavorites(id: String) {
        cryptoCache.addOrRemoveFromFavorites(id)
    }

    override suspend fun searchCryptos(): Flow<List<Crypto>> {
        return flowOf(cryptoCache.getAllCryptos())
    }
}
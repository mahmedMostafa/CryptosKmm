package com.mohamed.mostafa.cryptocurrencies.core.datasource.local.cryptos

import com.mohamed.mostafa.cryptocurrencies.core.datasource.remote.ApiService.Constants.PAGINATION_PER_PAGE_COUNT
import com.mohamed.mostafa.cryptocurrencies.data.cache.CryptosDatabase
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.mappers.toDomainList
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.mappers.toDomainModel
import com.mohamed.mostafa.cryptocurrencies.features.cryptos_list.domain.models.SearchSort
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.Crypto
import com.mohamed.mostafa.cryptocurrencies.shared.domain.models.PriceState
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CryptosDaoImpl(
    private val cryptosDatabase: CryptosDatabase,
) : CryptoDao {

    private val queries = cryptosDatabase.cryptosDbQueries

    override fun insertCrypto(crypto: Crypto) {
        queries.insertCrypt(
            id = crypto.id ?: "",
            name = crypto.name ?: "",
            symbol = crypto.symbol ?: "",
            marketCapRank = crypto.marketCapRank?.toLong() ?: 0L,
            image = crypto.image ?: "",
            currentPrice = crypto.currentPrice ?: 0.0,
            marketCap = crypto.marketCap ?: 0L,
            priceState = crypto.priceState?.name ?: PriceState.STILL.name
        )
    }

    override fun insertCryptos(cryptos: List<Crypto>) {
        cryptos.forEach { crypto ->
            insertCrypto(crypto)
        }
    }

    override fun updateCryptoDetail(id: String, description: String) {
        queries.updateCryptoDetails(id = id, description = description)
    }

    override fun addOrRemoveFromFavorites(id: String) {
        queries.transaction {
            val crypto = queries.getCryptoById(id).executeAsOne().toDomainModel()
            if (crypto.isFavorite == true) {//this also checks for null value
                queries.removeFromFavorites(id)
            } else {
                queries.addToFavorites(id)
            }
        }
    }

    override fun getCryptoById(id: String): Crypto {
        return queries.getCryptoById(id).executeAsOne().toDomainModel()
    }

    override fun getCryptos(page: Int): List<Crypto> {
        return queries.getCryptosByPage(
            pageSize = PAGINATION_PER_PAGE_COUNT.toLong(),
            offset = ((page - 1) * PAGINATION_PER_PAGE_COUNT).toLong(),
        ).executeAsList().toDomainList()
    }

    override fun getAllCryptos(): List<Crypto> {
        return queries.getAllCryptos().executeAsList().toDomainList()
    }

    override fun searchCryptos(query: String, sort: SearchSort): Flow<List<Crypto>> {
        return if (sort is SearchSort.ByName) {
            queries.searchCryptosOrderdByName(query).asFlow().mapToList()
                .map { it.toDomainList() }
        } else {
            queries.searchCryptosOrderdByPrice(query).asFlow().mapToList()
                .map { it.toDomainList() }
        }
    }

    override fun deleteCrypto(id: String) {
        queries.deleteCryptoById(id)
    }

    override fun clearCryptos() {
        queries.clearCryptos()
    }
}